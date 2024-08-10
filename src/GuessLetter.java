public class GuessLetter {
        //GuessLetter is a class used to create the letters of the guess. It is to be used to check against the
        //real letters in the actual word

        //statusColor is used to track the color (ie the status) of the letter.


        private final char firmLetter;
        private final int firmPosition;
        private int statusColor = 0;
        private int boundToPosition = 0;



        //Position and Letter match are used to track the guess status of the letter
        //They will also be used to determine the correct statusColor
        private boolean positionMatch = false;
        private boolean letterMatch = false;
        GuessLetter(char letter, int position){
            firmLetter = letter;
            firmPosition = position;
        }



    public char getLetter(){
            return firmLetter;
        }
    public int getPosition(){
            return firmPosition;
        }

    public String toString(){
        return "++++" + "letter: " + getLetter() + " position: " + getPosition() + " Status: " + getStatusColor()
                + " positionMatch: " + getPositionMatch() + " letterMatch: " + getLetterMatch() + "++++";
    }

    public int getStatusColor(){
            return statusColor;
    }
    public void setStatusColor(int status){
            //System.out.println("status changed from " +statusColor + " to: " + status);
            statusColor = status;
    }

    public void setLetterMatch(boolean bool){
            letterMatch=bool;
    }
    public void setPositionMatch(boolean bool){
            positionMatch=bool;
    }


    public boolean getLetterMatch(){
            return letterMatch;
    }
    public boolean getPositionMatch(){
        return positionMatch;
    }
    public void setBoundToPosition(int position){
            boundToPosition = position;
    }
    public int getBoundToPosition(){
            return boundToPosition;
    }

    }


