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

    private String playersGuess = new String();


    Scanner checker  = new Scanner(System.in);


   //Upon creation of a Game object, gameWord is created, an object of the Word class that is made using the
    //word chosen from Game's wordList
    Game(){
        Word gameWord = new Word(chosenWord);
        System.out.println(chosenWord);
        gameWord.printOutWord();
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


}
