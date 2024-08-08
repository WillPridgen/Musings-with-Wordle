public class GuessLetter {
        //GuessLetter is a class used to create the letters of the guess. It is to be used to check against the
        //real letters in the actual word


        private final char firmLetter;
        private final int firmPosition;


        private GuessLetter(char letter, int position){
            firmLetter = letter;
            firmPosition = position;
        }



    public char getLetter(){
            return firmLetter;
        }

        public int getPosition(){
            return firmPosition;
        }
    }


