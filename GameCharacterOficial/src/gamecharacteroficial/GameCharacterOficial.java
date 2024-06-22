
package gamecharacteroficial;

import Controller.GameController;
import Entities.GameCharacter;
import Views.Console;
import java.util.Scanner;


public class GameCharacterOficial {

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        GameCharacter character=new GameCharacter();
        Console view=new Console();
        GameController controller=new GameController(character, view);
        
        boolean seguir=true;
        while(seguir){
            controller.agregarJugadores();
            controller.mostrarJugador();
            controller.mostrarMapa();
            controller.moverJugadores();
            view.showStatus("Deseas seguir Jugando?, responder con si o no");
            String respuesta = teclado.nextLine().trim().toUpperCase(); 
            if(respuesta.matches("SI")) {
                seguir=true;
            }
            else if(respuesta.matches("NO")) {
                seguir=false;
            }
            else{
                view.showStatus("La respuesta es incorrecta");
                seguir=false;
            }
        
        }
    }
    
}
