import java.util.ArrayList;

public class Word {
    private final ArrayList<RealLetter> arrayWord = new ArrayList<RealLetter>();

    //At the initialization of a Word object, the chosen word for the game is passed in.
    //This word is then converted to a char list, which is then used to create individual RealLetters.
    //these RealLetter objects are then added to arrayWord, which when finished will act as the "word"
    //that is being guessed for.
    Word(String wordGiven){
        //Word class is used to create the arrayList of RealLetters that will constitute the word.
        char[] charArrayOfWord = wordGiven.toCharArray();
        int index = 0;
        for (char charOut:charArrayOfWord) {
            arrayWord.add(new RealLetter(charOut,index));
            index++;
        }
    }


    public ArrayList<RealLetter> getArrayWord(){
        return arrayWord;
    }

    public void printArrayList(){
        System.out.println(arrayWord);
    }

}
