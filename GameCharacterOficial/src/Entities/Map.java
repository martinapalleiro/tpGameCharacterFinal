
package Entities;



public class Map{
    protected GameCharacter[][] map;

    public Map(GameCharacter[][] map) {
        this.map = map;
        
    }
    
   
    public void agregarCharacter(GameCharacter character) {
        map[character.getX()][character.getY()] = character;
    }
    
    public Map(int rows, int cols) {
        map = new GameCharacter[rows][cols];
    }
    
    public boolean posicionValida(int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return false; 
        }

       return true;
    }
     public GameCharacter[][] getCharacters() {
        return map;
    }
    public GameCharacter getCharacter(int x, int y) {
        if (posicionValida(x, y)) {
            return map[x][y];
        } else {
            return null;
        }
    }
    public void setCharacter(int x, int y, GameCharacter character, int xAntiguo, int yAntiguo) {
        if (posicionValida(x, y)) {
            removeCharacter(xAntiguo, yAntiguo);
            map[x][y] = character;
        }
    }
    
    public void removeCharacter(int xAntiguo, int yAntiguo) {
        map[xAntiguo][yAntiguo] = null;
    }
    
    public boolean buscarEnemigo(){
      boolean enemigoEncontrado=false;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != null) {
                    if(map[i][j].getSymbol()=='E'){
                        enemigoEncontrado=true;
                    }
                }
            }
   
        }
        return enemigoEncontrado;
    }
    public boolean buscarPlayer(){
      boolean jugadorEncontrado=false;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != null) {
                    if(map[i][j].getSymbol()=='E'){
                        jugadorEncontrado=true;
                    }
                }
            }
   
        }
        return jugadorEncontrado;
    }
}
