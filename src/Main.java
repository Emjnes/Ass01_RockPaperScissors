import java.util.Scanner;
import java.util.Random;

class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        do {
            System.out.println("Let's play Rock, Paper, Scissors!");
            System.out.println("Enter Player A's move (R for Rock, P for Paper, S for Scissors):");
            String playerAChoice = getPlayerMove(scanner);

            System.out.println("Enter Player B's move (R/P/S):");
            String playerBChoice = getPlayerMove(scanner);

            System.out.println("Player A chose: " + playerAChoice);
            System.out.println("Player B chose: " + playerBChoice);

            String result = determineWinner(playerAChoice, playerBChoice);
            System.out.println(result);

            System.out.println("Do you want to play again? (Y/N)");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getPlayerMove(Scanner scanner) {
        String move;
        do {
            move = scanner.nextLine().toUpperCase();
            if (!move.equals("R") && !move.equals("P") && !move.equals("S")) {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));
        return move;
    }

    private static String determineWinner(String playerAChoice, String playerBChoice) {
        if (playerAChoice.equals(playerBChoice)) {
            return "It's a tie!";
        } else if ((playerAChoice.equals("R") && playerBChoice.equals("S")) ||
                (playerAChoice.equals("P") && playerBChoice.equals("R")) ||
                (playerAChoice.equals("S") && playerBChoice.equals("P"))) {
            return "Player A wins! " + getResultPhrase(playerAChoice, playerBChoice);
        } else {
            return "Player B wins! " + getResultPhrase(playerBChoice, playerAChoice);
        }
    }

    private static String getResultPhrase(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) {
            return "Rock breaks Scissors";
        } else if (winner.equals("P") && loser.equals("R")) {
            return "Paper covers Rock";
        } else if (winner.equals("S") && loser.equals("P")) {
            return "Scissors cuts Paper";
        }
        return "";
    }
}
