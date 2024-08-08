import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Game {
    //List of words that can be chosen for game
    static String[] wordList = {"THAT","THIS","WITH","FROM","YOUR","HAVE","MORE","WILL","HOME","PAGE","FREE","TIME",
            "THEY","SITE","WHAT","NEWS","ONLY","WHEN","HERE","ALSO","HELP","VIEW","BEEN","WERE","SOME","LIKE","THAN",
            "FIND","DATE","BACK","LIST","NAME","JUST","OVER","YEAR","INTO","NEXT","USED","WORK","LAST","MOST","DATA",
            "MAKE","THEM","POST","CITY","SUCH","BEST","THEN","GOOD","WELL","INFO","HIGH","EACH","VERY","BOOK","READ",
            "NEED","MANY","USER"};

    //Creates random Int used to choose word for game
    static int rand_int = new Random().nextInt(wordList.length);

    //Sets word for game based on word list and random int as described
    static String chosenWord = (String) Array.get(wordList , rand_int);

    Scanner checker  = new Scanner(System.in);
    private final Word gameWord;

    //Upon creation of a Game object, gameWord is created, an object of the Word class that is made using the
    //word chosen from Game's wordList
    Game(){
        gameWord = new Word(chosenWord);
        System.out.println(chosenWord);
        gameWord.printOutWord();
    }

    public static String getSicko() {
        return "sicko";
    }
    public Word getGameWord(){
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
            if(userGuess.matches("[a-zA-Z]+")){
                if ((userGuess.length() == 4)) {
                    validated = true;
                }  else {
                    System.out.println("Guess can only be 4 letters long");
                }
            }else {
                System.out.println("Guess can only be letters");
            }

        }
        System.out.println("you submitted " + userGuess);
        String upperGuess = userGuess.toUpperCase();
        return new Guess(upperGuess);
    }

    //checkIfGuessInWord is used to compare the Guess to the Word. It takes in both the Guess and the word, and will
    //Ideally check them and set statusColors as needed.
    public void checkIfGuessInWord(Word realWord, Guess newGuess){
        //this first part checks each letter of the guess against each letter of the real word.
        //It will need adjustment to work with the false yellow system that will be added.
        for(GuessLetter gLetter:newGuess.getArrayWord()){
            for(RealLetter realLetter:realWord.getArrayWord()){
                if(gLetter.getLetter() == realLetter.getLetter()){
                    gLetter.setLetterMatch(true);
                    if (gLetter.getPosition() == realLetter.getPosition()){
                        gLetter.setPositionMatch(true);
                    }
                }
            }

        }

        //This second part looks at each letter in the guess and sets its status based on the letter and postion bools
        for(GuessLetter gLetter:newGuess.getArrayWord()){
            if (gLetter.getLetterMatch()){
                if(gLetter.getPositionMatch()){
                    gLetter.setStatusColor(2);
                }else {
                gLetter.setStatusColor(1);}

            }else{
                gLetter.setStatusColor(0);
            }
        }
    }


}
