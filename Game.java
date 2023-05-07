import java.util.*;

public class Game {

    /**
     * Play the Game.
     */
    public void playGame(){
        // Welcome the player and explain the game.
        System.out.println("Hello. Welcome to Word Hunter.");
        System.out.println("This is how to play.");

        //Ask the user if they're ready to start
        Scanner obj = new Scanner(System.in);
        System.out.println("Hit enter when you are ready to play.");
        // Play the round

        String ctn = "Y";
        while(ctn.equals("Y")){
            playRound();

            // After the round ends.
            // Ask the user if they want to play another round.
            System.out.println("would you like to play another round?(Y/N)");
            ctn = obj.nextLine();

            // Make sure that the user enters a valid input.
            // Keep asking until they enter a valid input.
            while(!(ctn.equals("Y") || ctn.equals("N"))){
                System.out.println("That was not a valid entry. Please give a valid entry.");
                System.out.println("would you like to play another round?(Y/N)");
                ctn = obj.nextLine();
            }
        }
    }

    /**
     *
     */
    public void playRound(){

    }
}
