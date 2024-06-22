
package Views;

import Entities.GameCharacter;
import Entities.Map;
import java.util.Scanner;

public class Console {
    protected Scanner teclado=new Scanner(System.in);
    
    public void showMap(Map map) {
        GameCharacter[][] characters = map.getCharacters();

        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                if (characters[i][j] != null) {
                    System.out.print(characters[i][j].getSymbol());
                } else {
                    System.out.print("."); // Espacio vacío si no hay personaje en esa posición
                }
            }
            System.out.println(); 
        }
    }
    public String askUserMove() {
        System.out.print("Introduce tu movimiento (WASD) para mover el jugador): ");
        String movimiento = teclado.nextLine().trim().toUpperCase(); 
    
        if (movimiento.matches("[WASD]")) {
            return movimiento; 
        } else {
            System.out.println("Entrada no válida. Por favor, introduce una de las siguientes opciones: W, A, S, D");
            return askUserMove(); // Volver a pedir al usuario que introduzca un movimiento válido
        }
    }
     public void showStatus(String texto) {
        System.out.println(texto);
    }

}
