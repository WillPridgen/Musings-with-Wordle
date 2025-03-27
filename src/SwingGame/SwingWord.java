package src.SwingGame;






import java.util.ArrayList;

public class SwingWord {
    //arrayWord is the array of RealLetters that makes up the word that is being guessed.
    private final ArrayList<RealLetterSwing>arrayWord = new ArrayList<RealLetterSwing>();

    //At the initialization of a Word object, the chosen word for the game is passed in.
    //This word is then converted to a char list, which is then used to create individual RealLetters.
    //these RealLetter objects are then added to arrayWord, which when finished will act as the "word"
    //that is being guessed for.

    boolean isSolved = false;
    SwingWord(String wordGiven){
        //Word class is used to create the arrayList of RealLetters that will constitute the word.
        wordGiven = wordGiven.toUpperCase();
        char[] charArrayOfWord = wordGiven.toCharArray();
        int index = 0;
        for (char charOut:charArrayOfWord) {
            arrayWord.add(new RealLetterSwing(charOut,index));
            index++;
        }
    }

    public ArrayList<RealLetterSwing> getArrayWord(){
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

    public boolean checkIfSolved(ArrayList<GuessLetterSwing> guessList){
        for(GuessLetterSwing guesses:guessList){
            if(guesses.getStatusColor()!=2){
                return false;
            }
        }
        return true;

    }
    public void resetStatus(){
        for(RealLetterSwing letter: arrayWord){
            letter.setAttachedLetter(null);
            letter.setHasBeenSolved(false);
            letter.setGuessedInWord(false);
        }
    }

}
