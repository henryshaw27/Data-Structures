import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Player 1: choose a move (ROCK, PAPER, SCISSORS)");
        String player1 = sc1.nextLine().toUpperCase(); // Convert input to uppercase for case-insensitive comparison
        System.out.println("Player 2: Choose a move (ROCK, PAPER, SCISSORS)");
        String player2 = sc1.nextLine().toUpperCase(); // Convert input to uppercase for case-insensitive comparison




        switch (player1) {
            case "ROCK":
                if (player2.equals(Moves.Group.getScissors())) {
                    System.out.println("Player 1 Wins.");
                } else if (player2.equals(Moves.Group.getPaper())) {
                    System.out.println("Player 2 Wins.");
                }else if (player2.equals(Moves.Group.getRock())){
                    System.out.println("Draw");
                }
                break;
            case "PAPER":
                if (player2.equals(Moves.Group.getRock())) {
                    System.out.println("Player 1 Wins.");
                } else if (player2.equals(Moves.Group.getScissors())) {
                    System.out.println("Player 2 Wins.");
                }else if (player2.equals(Moves.Group.getPaper())){
                    System.out.println("Draw.");
                }
                break;
            case "SCISSORS":
                if (player2.equals(Moves.Group.getPaper())) {
                    System.out.println("Player 1 Wins.");
                } else if (player2.equals(Moves.Group.getRock())) {
                    System.out.println("Player 2 Wins.");
                }else if (player2.equals(Moves.Group.getScissors())){
                    System.out.println("Draw.");
                }
                break;
            default:
                System.out.println("Invalid input. Please enter ROCK, PAPER, or SCISSORS.");
                break;
        }
    }
}