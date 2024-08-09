public class RealLetter {
    //RealLetter is a class used to create the letters of the word. They will track their postion
    //in the word, as well as if they have been guessed.


    private final char firmLetter;
    private final int firmPosition;

    //hasBeenSolved and guessedInWord are booleans used to track the guessing
    //state of the letter. hasBeenSolved is set to false initially, if the guess
    //has it in the correct place , then it is set to true.
    //guessInWord is also set to false, if the guess has the correct letter, it is set to true
    //if both are true, the letter has been guessed fully.
    private boolean hasBeenSolved = false;
    private boolean guessedInWord = false;
    private GuessLetter attachedLetter = null;

    //RealLetter has two constructor instance variables. firmLetter is the letter that is passed when the object is created,
    //firmPosition is the position of the letter in the word. These should not be changed further on.
    RealLetter(char letter, int position){
        firmLetter = letter;
        firmPosition = position;
    }


    public GuessLetter getAttachedLetter(){
        return attachedLetter;
    }
    public void setAttachedLetter(GuessLetter newLetter){
        attachedLetter = newLetter;
    }
    public int getAttachedLetterStatus(){
        return attachedLetter.getStatusColor();
    }

    public boolean getHasBeenSolved(){
        return hasBeenSolved;
    }

    public void setHasBeenSolved(boolean setter){
        hasBeenSolved=setter;
    }

    public boolean getGuessedInWord(){
        return guessedInWord;
    }

    public void setGuessedInWord(boolean setter){
        guessedInWord=setter;
    }

    public char getLetter(){
        return firmLetter;
    }

    public int getPosition(){
        return firmPosition;
    }

    public String toString(){
        return "<letter: " + getLetter() + " position: " + getPosition() +">";
    }
}
