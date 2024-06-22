
package Controller;

import Entities.Combatant;
import Entities.Enemy;
import Entities.GameCharacter;
import Entities.Map;
import Entities.Player;
import Entities.Weapon;
import Views.Console;
import java.util.Random;

public class GameController {
    private GameCharacter character;
    private Map gameMap;
    private Console view;
    private Player player;
    private Enemy enemy;
    private Weapon Weapon;

    public GameController(GameCharacter character, Console view) {
        this.character = character;
        this.gameMap =  new Map(5, 5);
        this.view = view;
        this.player = new Player("Profe Santini",Weapon,100,100, rand.nextInt(5),rand.nextInt(5), 'P');
        this.enemy = new Enemy(100,100,rand.nextInt(5),rand.nextInt(5),'E',rand.nextInt(99));
        this.Weapon= new Weapon("Pistola Glock",90,10);
        player.setWeapon(Weapon);
    }
    Random rand=new Random();
    
    
    
    public void mostrarJugador(){
      System.out.println(player.toString());
      System.out.println(Weapon.toString());
        
    }
    
    public void combat(GameCharacter attacker, GameCharacter defender) {
        mostrarMapa();
        if (attacker instanceof Combatant) {
            Combatant combatant = (Combatant) attacker;
            int damage = combatant.attack();

            defender.reduceHealth(damage);
            view.showStatus(attacker.toString() + " ataca a " + defender.toString() + " por " + damage + " puntos de daño.");

            if (defender.getCurHp() > 0) {
                view.showStatus(defender.toString() + " tiene " + defender.getCurHp() + " puntos de vida restantes.");
            }
        } else {
            view.showStatus("No se puede iniciar el ataque.");
        }
    
        if (defender instanceof Combatant) {
            Combatant combatant = (Combatant) defender;
            int damage = combatant.attack();

            attacker.reduceHealth(damage);
            view.showStatus(defender.toString() + " ataca a " + attacker.toString() + " por " + damage + " puntos de daño.");
            
            if (attacker.getCurHp() <= 0) {
                eliminarPlayer(attacker);  
                view.showStatus(attacker.toString() + " ha sido derrotado.");
            } else {
                view.showStatus(attacker.toString() + " tiene " + attacker.getCurHp() + " puntos de vida restantes.");
            }
        } else {
            view.showStatus("No se puede iniciar el ataque.");
        }
    }
    public void move(GameCharacter character, int x, int y) {
        int posicionAntiguaX=character.getX();
        int posicionAntiguaY= character.getY();
        if (gameMap.posicionValida(x, y)) {
           
            character.setX(x);
            character.setY(y);
            gameMap.setCharacter(x, y, character, posicionAntiguaX, posicionAntiguaY);
            
            encontrarEnemigosCerca(x,y);
        } 
    }
    public void verMovimiento(String movimiento){
        
      switch (movimiento) {
          case "W":
                move(player, player.getX()-1, player.getY());
                break;
            case "S":
               
                move(player, player.getX()+1, player.getY());
                break;
            case "A":
        
                move(player, player.getX(), player.getY()-1);
                break;
            case "D":
                
                move(player, player.getX(), player.getY()+1);
                break;
        }
    }
    
    public void agregarJugadores(){
        enemy.setCurHp(100);
        player.setCurHp(100);
        gameMap.agregarCharacter(enemy);
        gameMap.agregarCharacter(player);
    }
    public void mostrarMapa(){
        view.showMap(gameMap);
    }
    public void moverJugadores(){
       boolean enemigoEncontrado=gameMap.buscarEnemigo();
       boolean playerEncontrado=gameMap.buscarPlayer();
        while (enemigoEncontrado&&playerEncontrado) {
            String movimiento =view.askUserMove();
            verMovimiento(movimiento);
            mostrarMapa();  
            enemigoEncontrado=gameMap.buscarEnemigo();
            if(player.getCurHp()<=0) {
            playerEncontrado=false;
            }
            
        }
        if(!enemigoEncontrado){
           view.showStatus("Enemigo eliminado");
        }
        else if(!playerEncontrado) 
            view.showStatus("Has sido eliminado");
    
    }
    private void encontrarEnemigosCerca(int nuevaPosX, int nuevaPosY) {
       // Definir el rango en el que consideras "cerca". Por ejemplo, una distancia de 1 unidad.
        int rango = 1;
        Random random=new Random();
        for (int i = -rango; i <= rango; i++) {
            for (int j = -rango; j <= rango; j++) {
                // Evitar verificar la posición del propio jugador
                if (i == 0 && j == 0) continue;

                int posX = nuevaPosX + i;
                int posY = nuevaPosY + j;

                // Verificar si la posición es válida en el mapa
                if (gameMap.posicionValida(posX, posY)) {
                    GameCharacter personaje = gameMap.getCharacter(posX, posY);
                    if (personaje instanceof Enemy) {
                        // Si encontramos un enemigo cercano, iniciar el ataque
                        combat( personaje, player);
                        ubicarPlayer(player);
                    
                       if (player.getX() == posX && player.getY() == posY) {
                            move(player, random.nextInt(4), random.nextInt(4));
                            mostrarMapa();
                        }
                        return; // Salir del método después de encontrar y atacar al primer enemigo cercano
                    }
                }
            }
        }
    } 
    public void eliminarPlayer(GameCharacter player){
        if(player.getCurHp() <= 0){
            gameMap.removeCharacter(player.getX(), player.getY());
            view.showStatus(player.toString() + " ha sido eliminado.");
        }
    }
    public void ubicarPlayer(GameCharacter player){
        Random random=new Random();
        int xRandom, yRandom;
        xRandom= random.nextInt(4);
        yRandom= random.nextInt(4);
        move(player, xRandom, yRandom);
        player.setX(xRandom);
        player.setY(yRandom);
        eliminarPlayer(player);
    }
 
}
