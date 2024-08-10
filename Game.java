import java.util.ArrayList;
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
    //static String chosenWord = (String) Array.get(wordList , rand_int);
    static String chosenWord = "etts";
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
        //this is outdated, will be removed.
        System.out.println(realWord.getArrayWord()+ " this is the orginal");
        ArrayList<RealLetter> tempArrayOfWords = (ArrayList<RealLetter>)realWord.getArrayWord().clone();
        System.out.println(tempArrayOfWords+ " this is the clone");
        //this first part checks each letter of the guess against each letter of the real word.
        //It will need adjustment to work with the false yellow system that will be added.
        for(GuessLetter gLetter:newGuess.getArrayWord()){
            //for each letter in the guess word
            for(RealLetter realLetter:realWord.getArrayWord()) {
                //if realLetter has not been marked as solved
                if (!realLetter.getHasBeenSolved()) {
                    //for each letter in the real word
                    if (gLetter.getLetter() == realLetter.getLetter()) {
                        //if the guess letter matches the real letter
                        gLetter.setLetterMatch(true);
                        //set the guess to a true letterMatch


                        if (gLetter.getPosition() == realLetter.getPosition()) {
                            //if the position of the guess letter is equal to the position of the real letter
                            gLetter.setPositionMatch(true);
                            realLetter.setHasBeenSolved(true);
                            ///if it does match the position, set the guess positionMatch to true
                        }


                        System.out.println(realLetter.getAttachedLetter() + "   hello!!!");
                        if (realLetter.getAttachedLetter() == null) {
                            System.out.println(realLetter);
                            realLetter.setAttachedLetter(gLetter);
                            //if the real letter has no attachedLetter, then attach the guess letter, as it matches the
                            //char of the letter

                        } else {
                            if (!realLetter.getAttachedLetter().getPositionMatch() && gLetter.getPositionMatch()) {
                                System.out.println(realLetter.getAttachedLetterStatus() + gLetter.getStatusColor());
                                realLetter.getAttachedLetter().setPositionMatch(false);
                                realLetter.getAttachedLetter().setLetterMatch(false);
                                realLetter.setAttachedLetter(gLetter);
                            }

                        }
                    }
                }

            }
            }



        //This second part looks at each letter in the guess and sets its status based on the letter and postion bools
//        for(GuessLetter gLetter:newGuess.getArrayWord()){
//            if (gLetter.getLetterMatch()){
//                if(gLetter.getPositionMatch()){
//                    gLetter.setStatusColor(2);
//                }else {
//                gLetter.setStatusColor(1);}
//
//            }else{
//                gLetter.setStatusColor(0);
//            }
//        }

        System.out.println(realWord.getArrayWord());
        //for each realLetter in the realWord array
        for(RealLetter realLetter:realWord.getArrayWord()){
            //if the letter has been solved
            if(realLetter.getHasBeenSolved()){
                //set its attached letter status to 2
                realLetter.getAttachedLetter().setStatusColor(2);
            }
            //if the letter attached exists, and the letter matches, and the position doesn't match
            if(realLetter.getAttachedLetter() != null && realLetter.getAttachedLetter().getLetterMatch() && !realLetter.getAttachedLetter().getPositionMatch()){
                //set the attached letter's status to 1
                realLetter.getAttachedLetter().setStatusColor(1);

            }
        }
    }
    public void newCheckGuess(Word realWord, Guess newGuess){

        int index = 0;
        //index is used to go through the list


        ArrayList<GuessLetter> guessArray1 = newGuess.getArrayWord();
        ArrayList<RealLetter> realArray1 = realWord.getArrayWord();
        //these two arraysLists are used to make accessing the for the words somewhat shorter


        for(GuessLetter guessLetter:newGuess.getArrayWord()){
            //for each guessLetter in the guess array


            if(guessArray1.get(index).getLetter() == realArray1.get(index).getLetter()){
                //if the guess and real letter match
                guessArray1.get(index).setLetterMatch(true);
                //set the letter match of the guess to true
                if(guessArray1.get(index).getPosition() == realArray1.get(index).getPosition()){
                    //if the guess and real position match
                    guessArray1.get(index).setPositionMatch(true);
                    //set the position match of the guess to true
                }
                if(realArray1.get(index).getAttachedLetter() == null){
                    //if the attached letter for the real letter is not set (ie null)
                    realArray1.get(index).setAttachedLetter(guessArray1.get(index));
                    //set the attached letter to the guessed letter.
                    //this works because we are in the point of the loop that has already confirmed that
                    //the letter is matched at least. We will check to make sure the actual position is the same later


                }else{
                    //if the real letter does have an attached letter then ->
                    if(!realArray1.get(index).getAttachedLetter().getPositionMatch() &&
                            guessArray1.get(index).getPositionMatch()){
                        //if the attached letter does not have a true position match
                        //(meaning it is the right letter but the wrong place) and the letter being guessed has a
                        // true position match then set the attached letter to the guess.

                        realArray1.get(index).setAttachedLetter(guessArray1.get(index));

                    }else{
                        //if the attached letter position match is true or the new guess letter's position is false
                        //set the new guess letter match to false, as it is less correct than the previously
                        //attached guess
                        realArray1.get(index).getAttachedLetter().setLetterMatch(false);
                    }
                }
            }

        index++;
        //increase the index by one
        }
        for(GuessLetter guessLetter:newGuess.getArrayWord()) {
            //for each guess letter in the guess array
            if(guessLetter.getLetterMatch()){
                //if the guess has a true letter match
                guessLetter.setStatusColor(1);
                //set the status to 1 (yellow)
                if(guessLetter.getPositionMatch()){
                    //if the guess has a true position match
                    guessLetter.setStatusColor(2);
                    //set the status to 3 (green)
                }
            }else{
                //if the letter is false, then it is set to status of 0 (grey)
                guessLetter.setStatusColor(0);
            }
        }
    }




}
