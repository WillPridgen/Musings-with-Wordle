package src;

import java.util.ArrayList;

public class Word {
    private final ArrayList<RealLetter> arrayWord = new ArrayList<RealLetter>();
   // private char[] charArrayOutside = new char[4];
    //At the initialization of a Word object, the chosen word for the game is passed in.
    //This word is then converted to a char list, which is then used to create individual RealLetters.
    //these RealLetter objects are then added to arrayWord, which when finished will act as the "word"
    //that is being guessed for.


    boolean isSolved = false;
    Word(String wordGiven){
        //Word class is used to create the arrayList of RealLetters that will constitute the word.
        wordGiven = wordGiven.toUpperCase();
        char[] charArrayOfWord = wordGiven.toCharArray();
        int index = 0;
        for (char charOut:charArrayOfWord) {
            arrayWord.add(new RealLetter(charOut,index));
            index++;
        }
        //charArrayOutside = charArrayOfWord;
    }


    public ArrayList<RealLetter> getArrayWord(){
        return arrayWord;
    }

    public void printOutWord(){
        System.out.println(arrayWord);
    }

    public boolean getIsSolved(){
        return isSolved;
    }
    public void setIsSolved(boolean solved){
        isSolved = solved;
    }

    public boolean checkIfSolved(ArrayList<GuessLetter> guessList){
        for(GuessLetter guesses:guessList){
            if(guesses.getStatusColor()!=2){
                return false;
            }
        }
        return true;

    }
    public void resetStatus(){
        for(RealLetter letter: arrayWord){
            letter.setAttachedLetter(null);
            letter.setHasBeenSolved(false);
            letter.setGuessedInWord(false);
        }
    }
}
