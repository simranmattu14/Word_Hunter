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
        String start = obj.nextLine();
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
        // Initialize the dictionary
        Dictionary dict = new Dictionary("five_letter_words.txt");
        List<String> correctWords = new ArrayList<String>();

        // Get a random number
        // This would be used to choose a random word in the dictionary.
        Random rand = new Random();
        int num = rand.nextInt(0, 5757);
        String word = dict.getWord(num);
        System.out.println("The Word is:" + word);
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

    private String checkingUserInput(Dictionary dict){
        StringBuilder word = new StringBuilder();
        Scanner obj = new Scanner(System.in);
        while(!dict.containsWord(word.toString())){
            word = new StringBuilder();
            System.out.println("Not a valid entry.");
            System.out.println("What is your guess?");
            word.append(obj.nextLine());
        }
        return word.toString();
    }

    /**
     * Compared the random word chosen and compares how well the user guessed the word.
     * @param word
     * @param userWord
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
