import java.util.Random;
import java.util.Scanner;

class CrapsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain;

        do {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;
            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + crapsRoll);

            // Initial roll conditions
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! You crapped out and lost.");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You rolled a 7 or 11 and won.");
            } else {
                // Point is established
                int point = crapsRoll;
                System.out.println("Point is now: " + point);
                boolean rolling = true;

                while (rolling) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    int newRoll = die1 + die2;
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + newRoll);

                    if (newRoll == point) {
                        System.out.println("You made the point! You won.");
                        rolling = false;
                    } else if (newRoll == 7) {
                        System.out.println("You rolled a 7! You lost.");
                        rolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Prompt to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = input.next().toLowerCase();
            playAgain = response.equals("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
        input.close();
    }
}