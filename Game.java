import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Game {
    //List of words that can be chosen for game
    static String[] wordList = {"THAT", "THIS", "WITH", "FROM", "YOUR", "HAVE", "MORE", "WILL", "HOME", "PAGE", "FREE", "TIME",
            "THEY", "SITE", "WHAT", "NEWS", "ONLY", "WHEN", "HERE", "ALSO", "HELP", "VIEW", "BEEN", "WERE", "SOME", "LIKE", "THAN",
            "FIND", "DATE", "BACK", "LIST", "NAME", "JUST", "OVER", "YEAR", "INTO", "NEXT", "USED", "WORK", "LAST", "MOST", "DATA",
            "MAKE", "THEM", "POST", "CITY", "SUCH", "BEST", "THEN", "GOOD", "WELL", "INFO", "HIGH", "EACH", "VERY", "BOOK", "READ",
            "NEED", "MANY", "USER"};

    //Creates random Int used to choose word for game
    static int rand_int = new Random().nextInt(wordList.length);

    //Sets word for game based on word list and random int as described
    static String chosenWord = (String) Array.get(wordList, rand_int);
    //static String chosenWord = "etts";
    Scanner checker = new Scanner(System.in);
    private final Word gameWord;

    //Upon creation of a Game object, gameWord is created, an object of the Word class that is made using the
    //word chosen from Game's wordList
    Game() {
        gameWord = new Word(chosenWord);
        //System.out.println(chosenWord);
       // gameWord.printOutWord();
    }

    public static String getSicko() {
        return "sicko";
    }

    public Word getGameWord() {
        return gameWord;
    }

    public Guess getPlayersGuess() {
        //Method used to gather guess from user via input at terminal
        boolean validated = false;
        String userGuess = null;
        //this section checks to make sure user guess is 4 letters, with no other characters.
        while (!validated) {
            System.out.println("Enter Guess:");
            userGuess = checker.nextLine();
            if (userGuess.matches("[a-zA-Z]+")) {
                if ((userGuess.length() == 4)) {
                    validated = true;
                } else {
                    System.out.println("Guess must be 4 letters long");
                }
            } else {
                System.out.println("Guess can only be letters");
            }

        }
        System.out.println("you submitted " + userGuess);
        String upperGuess = userGuess.toUpperCase();
        return new Guess(upperGuess);
    }

    //checkIfGuessInWord is used to compare the Guess to the Word. It takes in both the Guess and the word, and will
    //Ideally check them and set statusColors as needed.

    public void checkIfGuessInWord(Word realWord, Guess newGuess) {
        realWord.resetStatus();
        //This method compares the guesses word to the real word.
        ArrayList<RealLetter> tempArrayOfWords = (ArrayList<RealLetter>) realWord.getArrayWord().clone();
        //this clone of the real word arraylist is used later, as elements will be deleted from it
        for (GuessLetter guessLetter : newGuess.getArrayWord()) {
            //for each guessLetter in the guess arrayList
            Iterator<RealLetter> itr = tempArrayOfWords.iterator();
            //Iterator is used in order to have the removal component work without crashing
            while (itr.hasNext()) {
                //takes the place of a for each loop, allowing for removal of elements of the arrayList
                RealLetter realLetter = itr.next();
                //updates the iterator
                if (guessLetter.getLetter() == realLetter.getLetter()) {
                    //if the guess letter matches the real letter


                    if (guessLetter.getPosition() == realLetter.getPosition()) {
                        //if the positions match,
                        guessLetter.setPositionMatch(true);
                        //set the guess letters position to true

                        if (realLetter.getAttachedLetter() != null) {
                            //checks if there is a attached letter that may be a false yellow
                            realLetter.getAttachedLetter().setLetterMatch(false);
                            //sets the previously attached letter to false, thus eliminating a false positive of a 1 code
                        }

                        realLetter.setAttachedLetter(guessLetter);
                        //attaches the new guess with the correct position to the real letter
                        itr.remove();
                        //removes the real word from the temp arrayList


                    } else {
                        //if the position does not match,
                        if(realLetter.getAttachedLetter()==null){
                                realLetter.setAttachedLetter(guessLetter);
                                //attach the letter
                                guessLetter.setLetterMatch(true);
                                //set it's letterMatch to true, but not the position

                        }


                    }
                }
            }
        }
        for (GuessLetter guessLetter : newGuess.getArrayWord()) {
            //for each guess letter
            if (guessLetter.getLetterMatch()) {
                //if the guess letter is a letter match
                guessLetter.setStatusColor(1);
                //set it to 1 (yellow)
            } else {
                //if the guess letter is not a letter match, it cannot be a position match
                guessLetter.setStatusColor(0);
                //so it is set to 0 (grey/black/white) (wrong)
            }
            if (guessLetter.getPositionMatch()) {
                //if the position matches
                guessLetter.setStatusColor(2);
                //set the status to color 2 (Green)
            }
        }
    }

}
