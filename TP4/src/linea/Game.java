package linea;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dimensiones?");
        Linea game = new Linea(
                promptAsInt(scanner, "Base? "),
                promptAsInt(scanner, "Altura? "),
                promptAsChar(scanner, "Estrategia de Juego: A, B o C? ")
        );

        System.out.println(game.show());

        while (!game.finished()) {
            game.playRedAt(promptAsInt(scanner, "Rojas? "));
            System.out.println(game.show());

            if (!game.finished()) {
                game.playBlueAt(promptAsInt(scanner, "Azul? "));
                System.out.println(game.show());
            }
        }
    }

    private static int promptAsInt(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    private static char promptAsChar(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.next().charAt(0);
    }
}
