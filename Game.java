import java.util.*;

public class Game {

    /**
     * Play the Game.
     */
    public void playGame(){
        // Welcome the player and explain the game.
        System.out.println("Hello. Welcome to Word Hunter.");
        System.out.println("""
                Out of the dictionary, the game will pick a word and it will give you the number of
                 letters in the word. And then you would need to guess the word. You will be given letter bank
                 in which where we will put the letters you used that are in the word. After every guess, you will
                 see if you guessed any letters that were in the correct spot.""");
        System.out.println("You will get points based on the number guesses it takes you.\n");

        //Ask the user if they're ready to start
        Scanner obj = new Scanner(System.in);
        System.out.println("Hit enter when you are ready to play. \n");
        String start = obj.nextLine();

        // Play the round
        String ctn = "Y";
        while(ctn.equals("Y")){
            // Play the first round
            playRound();

            // After the round ends.
            // Ask the user if they want to play another round.
            System.out.println("Would you like to play another round?(Y/N) \n");
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
     * PlayRound plays each round which means that it finds a random word from the dictionary and
     * constantly get the user to keep guessing until they got the correct word.
     */
    public void playRound(){
        // Initialize the dictionary
        Dictionary dict = new Dictionary("five_letter_words.txt");
        List<String> correctWords = new ArrayList<String>();

        // Get a random number
        // This would be used to choose a random word in the dictionary.
        Random rand = new Random();
        int num = rand.nextInt(0, 5757);
        String word = dict.getWord(num);

        // --------------Testing Purposes--------------
        System.out.println("The Word is:" + word);
        // --------------Testing Purposes--------------

        String userWord = "";

        // Get the user to constantly ask the user for a word until they get the
        // right word.
        while(!userWord.equals(word)){
            // Asking the user for an input.
            userWord = checkingUserInput(dict);
            System.out.println("Result:\n" + correct_spot(word, userWord) +
                    "\nLetter Bank:" + correct_letters(word, userWord, correctWords));
        }
    }

    /**
     * This is a helper function that checks whether the user input is a valid word in the
     * dictionary.
     * @param dict The dictionary being used that round.
     * @return Either returns the given word or another valid word prompted by the user.
     */
    private String checkingUserInput(Dictionary dict){
        StringBuilder word = new StringBuilder();
        Scanner obj = new Scanner(System.in);
        while(!dict.containsWord(word.toString())){
            word = new StringBuilder();
            System.out.println("Not a valid entry.");
            System.out.println("Please enter a valid word:");
            word.append(obj.nextLine());
        }
        return word.toString();
    }

    /**
     * Compared the random word chosen and compares how well the user guessed the word.
     * Checks each spot of the word and gives an output that shows the user which
     * letters they got right and which they got wrong.
     * @param word The word chosen from the dictionary.
     * @param userWord This is the word given by the user.
     * @return
     */
    private String correct_spot(String word, String userWord){
        String correctSpots = "";
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == userWord.charAt(i)){
                correctSpots = correctSpots + String.valueOf(word.charAt(i));
            }else{
                correctSpots = correctSpots + String.valueOf("_");
            }
        }
        return correctSpots;
    }

    /**
     *
     * @param word
     * @param userWord
     * @return
     */
    private List correct_letters(String word, String userWord, List correctWords){
        for (int i = 0; i < userWord.length(); i++) {
            if(word.indexOf(userWord.charAt(i)) != -1 && !correctWords.contains(userWord.charAt(i))){
                correctWords.add(userWord.charAt(i));
            }
        }
        return correctWords;
    }
}
