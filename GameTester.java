public class GameTester {
    public static void main(String[] args){

        Game newGame = new Game();
        Word word = newGame.getGameWord();
        System.out.println(word);
        Guess newGuess = newGame.getPlayersGuess();
        System.out.println(newGuess.printOutStatusOfGuess());
        newGame.checkIfGuessInWord(word,newGuess);
        System.out.println(newGuess.printOutStatusOfGuess());
    }
}
