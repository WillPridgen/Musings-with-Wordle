package src.SwingGame;


//This class is a rewrite of the Game class. The goals are to provide more usable returns for using with the swing GUI


public class SwingGameEngine {
    private final SwingWord gameWord;
    WordSelect WordChoose = new WordSelect();
    String chosenWord = WordChoose.getWord();
    SwingGameEngine(){
        gameWord = new SwingWord(chosenWord);
    }
    public SwingWord getGameWord() {
        return gameWord;
    }




}
