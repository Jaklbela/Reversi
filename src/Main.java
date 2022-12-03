import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int input = -1;
        do {
            System.out.println("Hello! Welcome to reversi!\nEnter:\n1 - game with small bot\n" +
                    "2 - game with expert bot\n3 - player vs player game\n4 - human max points\n0 - exit");
            Scanner in = new Scanner(System.in);
            boolean is_input = false;
            while (!is_input) {
                is_input = in.hasNextInt();
                if (!is_input) {
                    System.out.println("Not a number! Try again");
                }
            }
            input = in.nextInt();
            switch (input) {
                case 0:
                    break;
                case 1: {
                    Game.SmallBotGame();
                    break;
                }
                case 2: {
                    Game.CoolBotGame();
                    break;
                }
                case 3: {
                    Game.PVPGame();
                    break;
                }
                case 4:
                    System.out.println("Maximum points of human player: " + Game.max_points);
            }
        } while (input != 0);
    }
}