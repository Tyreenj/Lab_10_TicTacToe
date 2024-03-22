import java.util.Scanner;

public class SafeInput {

    //Method for String Input
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        //Return variable
        String retString = "";  // Set this to zero length. Loop runs until it isn’t

        // Repeats Prompt until string is not empty
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            //Sets return variable to input
            retString = pipe.nextLine();
        } while (retString.isEmpty());

        return retString;

    }

    //Method for Int Input
    public static int getInt(Scanner pipe, String prompt) {
        //Return Variable
        int retInt = 0;
        //Trash Variable
        String trash;

        //Repeats until Int is a valid int
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                // Sets return variable to input
                retInt = pipe.nextInt();
                // Clears pipe
                pipe.nextLine();
                done = true;
            } else {
                //Gives error if int is not valid
                trash = pipe.nextLine();
                System.out.println("That is not a valid integer. " + trash);

            }
        } while (!done);

        return retInt;
    }

    //Method for double input
    public static double getDouble(Scanner pipe, String prompt) {
        // Return Variable
        double retDouble = 0;
        // Trash Variable
        String trash;

        //Repeats until input is an int
        boolean done = false;
        do {
            //Prints prompt
            System.out.print("\n" + prompt + ": ");

            //Checks if input is an int
            if (pipe.hasNextDouble()) {
                //Sets return variable
                retDouble = pipe.nextDouble();
                //Clears pipe
                pipe.nextLine();
                done = true;
            } else {
                //Error handling
                trash = pipe.nextLine();
                System.out.println("That is not a valid double. " + trash);
            }
        } while (!done);

        return retDouble;
    }

    //Method for Ranged Integer
    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi) {
        // Return int
        int retInt = 0;
        //Trash variable
        String trash;

        // Repeats until int is valid int and within range
        boolean done = false;
        do {
            //Prompt
            System.out.print("\n" + prompt + "[" + lo + "-" + hi + "] : ");
            //Checks if int is valid
            if (pipe.hasNextInt()) {
                //Sets return variable
                retInt = pipe.nextInt();
                //Clears pipe
                pipe.nextLine();
                //Checks if int is within range
                if (retInt >= lo && retInt <= hi) {
                    done = true;
                } else { // Error handling for not within range
                    System.out.println("That is not in the range. " + "[" + lo + "-" + hi + "]");
                }
            } else { // Error handling for non valid int
                trash = pipe.nextLine();
                System.out.println("That is not a valid integer. " + trash);
            }
        } while (!done);
        return retInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double lo, double hi) {
        double retInt = 0;
        String trash;

        boolean done = false;
        do {
            System.out.print("\n" + prompt + "[" + lo + "-" + hi + "] : ");
            if (pipe.hasNextDouble()) {
                retInt = pipe.nextDouble();
                pipe.nextLine();
                if (retInt >= lo && retInt <= hi) {
                    done = true;
                } else {
                    System.out.println("That is not in the range. " + "[" + lo + "-" + hi + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("That is not a valid integer. " + trash);
            }
        } while (!done);
        return retInt;
    }

    //Method to get true/false from y/n
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        //Return variable
        boolean retBool = false;
        // string to check whether y/n
        String checkBool;

        //Repeats until string = y or n
        boolean done = false;
        do {
            //Prompt
            System.out.print("\n" + prompt + "[Y/N] : ");
            //Set string to check y/n
            checkBool = pipe.nextLine();

            // Checks if string is y or no or invalid
            if (checkBool.equalsIgnoreCase("Y")) { // Yes
                done = true;
                retBool = true;
                //Clear pipe
                pipe.nextLine();
            } else if (checkBool.equalsIgnoreCase("N")) {   // No
                done = true;
            } else {    //Invalid/Error
                System.out.println("That is not a valid answer! [Y/N] " + checkBool);
            }
        } while (!done);

        return retBool;
    }

    //Get string input with regex pattern
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String value = "";

        //Repeats until String matches regex pattern
        boolean done = false;
        do {
            // Show the prompt
            System.out.print("\n" + prompt + " : ");
            // Input data
            value = pipe.nextLine();
            // Test data
            if (value.matches(regEx)) {
                // This is a match
                done = true;
                // Clear pipe
                pipe.nextLine();
            } else {
                //Does not match - ERROR
                System.out.println("\nInvalid Input : " + value);
            }
        } while (!done);

        return value;
    }

    public static void prettyHeader(String msg) {
        //Total num of char per line
        final int CHAR_COUNT = 60;

        //Variables for number of spaces in second line
        int totalSpaces = CHAR_COUNT - 6 - msg.length();
        int leftSpaces;
        int rightSpaces;

        // Checks if total num of spaces can be divided by 2 or not then sets left or right spaces accordingly
        if (totalSpaces % 2 == 0) {
            leftSpaces = rightSpaces = totalSpaces / 2; //Divisible by 2 evenly
        } else {    //Not evenly divisible by 2
            rightSpaces = totalSpaces / 2;
            leftSpaces = rightSpaces + 1;
        }

        //Prints first line of stars
        for (int ch = 0; ch < CHAR_COUNT; ch++) {
            System.out.print("*");
        }

        //Makes second line
        System.out.println();

        //Prints three stars
        for (int i = 0; i < 3; i++) {
            System.out.print("*");
        }

        //Prints the number of spaces between the left stars and the message.
        for (int ch = 0; ch < leftSpaces; ch++) {
            System.out.print(" ");
        }

        //Prints the message
        System.out.print(msg);

        //Prints the number of spaces between the message and the right stars
        for (int ch = 0; ch < rightSpaces; ch++) {
            System.out.print(" ");
        }

        //Prints the three stars on the right
        for (int i = 0; i < 3; i++) {
            System.out.print("*");
        }

        //Prints new line
        System.out.println();

        //Prints 60 stars on new line
        for (int ch = 0; ch < CHAR_COUNT; ch++) {
            System.out.print("*");
        }
    }
}
