package src.SwingGame;


import java.lang.reflect.Array;
import java.util.Random;

//This class has been extracted, generates the word that is to be guessed.
public class WordSelect {
    //List of words that can be chosen for game
    static String[] wordList = {"THAT", "THIS", "WITH", "FROM", "YOUR", "HAVE", "MORE", "WILL", "HOME", "PAGE", "FREE", "TIME",
            "THEY", "SITE", "WHAT", "NEWS", "ONLY", "WHEN", "HERE", "ALSO", "HELP", "VIEW", "BEEN", "WERE", "SOME", "LIKE", "THAN",
            "FIND", "DATE", "BACK", "LIST", "NAME", "JUST", "OVER", "YEAR", "INTO", "NEXT", "USED", "WORK", "LAST", "MOST", "DATA",
            "MAKE", "THEM", "POST", "CITY", "SUCH", "BEST", "THEN", "GOOD", "WELL", "INFO", "HIGH", "EACH", "VERY", "BOOK", "READ",
            "NEED", "MANY", "USER"};
    public String getWord(){
        //Creates random Int used to choose word for game
         int rand_int = new Random().nextInt(wordList.length);

        //Sets word for game based on word list and random int as described and returns
        return (String) Array.get(wordList, rand_int);
    }


}
