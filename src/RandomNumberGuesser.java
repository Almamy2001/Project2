//Programmer Almamy Aguibou Bah
import java.util.Scanner;

/**This is the Driver class of the RNG class
 * it is a game that ask the user to guess the
 * random number generated by RNG class until he finds
 * the right guess
 *
 * @author Almamy Aguibou Bah
 * @version 1.0
 * @since 2020-09-24
 */

public class RandomNumberGuesser {

    /**
     *  This the main method of this program
     *  Runs the other methods in this example
     *
     * @param args- array of String arguments passe form the Operating System
     */
    public static void main(String[] args) {

        //Creating a scanner object
        Scanner scanner= new Scanner(System.in);

        //Creating an instance of the class RNG
        RNG rng = new RNG();

        //To hold the random value that the RNG class will produce
        int randNum= RNG.rand();

        int nextGuess; //To hold the user guess
        int highGuess=100; //To hold the highest guess
        int lowGuess=0; //To hold the lowest guess

        //To know if the user wants to keep playing or not
        String playAgain="y";



        //Asking the user to enter his first guessdd
        System.out.println("Enter your first guess between 0-100");
        //Using a do-while loop to repeat as much as the user wants to play
        do {

            //To hold the guess that the user wil enter
            nextGuess = scanner.nextInt();

            //Outputting the user guess
            System.out.println("Number of guesses is " + RNG.getCount());

            //output if the user answers are higher than the result
            if (nextGuess > randNum) {
                System.out.println("Your guess is too high");

                //Setting a new highGuess
                highGuess=nextGuess; //updating high guess
            }

            //Output if the user answers are lowers than the result
            else if(nextGuess<randNum){
                System.out.println("Your guess is too low");

                //Setting a new low guess
                lowGuess=nextGuess;//updating low guess
            }

            //output if the player find the right answer
            else if (nextGuess == randNum) {
                System.out.println("Congratulations, you guessed correctly");

                //Asking the player if he wants to play again.
                System.out.println("Try again? (yes or no)");

                playAgain = scanner.next();


                //Output if the user does not want to play anymore
                if(playAgain.equalsIgnoreCase("n")){
                    System.out.println("Thanks for playing...\n");}

                //Resetting count, lowGuess, highGuess and random number if the user wants to play again
                else if(playAgain.equalsIgnoreCase("y")){
                    RNG.resetCount();
                    lowGuess=0;
                    highGuess=100;
                    System.out.println("\nEnter your first guess");
                    randNum=RNG.rand();

                }

            }
            //Using the input validation from RNG to output
            RNG.inputValidation(nextGuess, lowGuess, highGuess);

        }   while (playAgain.equalsIgnoreCase("y")) ;

        System.out.println("Programmer: Almamy Aguibou Bah");

    }
}
