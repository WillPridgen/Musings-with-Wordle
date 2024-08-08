//Guess class is used to create a arrayList of GuessLetters, that is made from the user inputted guess.
//it is similar to the Word class.

import java.util.ArrayList;

public class Guess {
    private final ArrayList<GuessLetter> arrayWord = new ArrayList<GuessLetter>();
    public Guess(String playerGuess){
        //At initialization, the player's guess is converted to a "word", i.e. a ArrayList of GuessLetters.
        char[] charArrayOfGuess = playerGuess.toCharArray();
        int index = 0;
        for(char wordChar:charArrayOfGuess){
            arrayWord.add(new GuessLetter(wordChar,index));
            index++;
        }


    }
    public void printOutWord(){
        System.out.println(arrayWord);
    }
    public ArrayList<GuessLetter> getArrayWord(){
        return arrayWord;
    }

    //printOutStatusOfGuess builds a string version of the guess that can be used to check progress.
    public String printOutStatusOfGuess(){
        String printOut = "";
        for(GuessLetter guessed:arrayWord){
            String letter = String.valueOf(guessed.getLetter());
            String status = String.valueOf(guessed.getStatusColor());
            printOut = printOut + letter+status;
        }
        return printOut;
    }
}

