import java.util.Scanner;

public class TicTacToe {

    /*
    function clearBoard()
        for each row in ROW
            for each col in COL
                board[row][col] = ""

    function display()
        for each row in ROW
            for each col in COL
                print board[row][col]
                if col < 2
                    print " | "
            print newline
            if row < 2
                for dash = 0 to 8
                    print "-"
                print newline

    function isValidMove(row, col) returns bool
        isValidMove = false
        if board[col][row] equals " "
            isValidMove = true
            count = count + 1
        if not isValidMove
            print "That stop is already taken! "
        return isValidMove

    function isWin(player) returns bool
        isWin = false
        if isColWin(player) or isRowWin(player or isDiagonalWin(player) and count >= 5
            isWin = true
            print "Player " +player + " wins!"
        return isWin

    function isColWin(player) returns bool
        isColWin = false
        for each col in COL
            if board[0][col] = player and board[1][col] = player and board[2][col] = player
                isColWin = true
        return isColWin

    function isRowWin(player) returns bool
        isRowWin = false
            for each row in ROW
                if board[row][0] = player and board[row][1] = player and board[row][2] = player
                    isRowWin = true
            return isRowWin

    function isDiagonalWin(player) returns bool
        isDiagonalWin = false
        if board[0][0] = player and board[1][1] = player and board[2][2] = player
            isDiagonalWin = true
        if board[2][0] = player and board[1][1] = player and board[0][2] = player
            isDiagonalWin = true
        return isDiagonalWin

    function isTie() returns bool
        isTie = false
        if isColTie() and isRowTie() and isDiagonalTie() and count >= 7
            isTie = true
            print "It's a tie!"
    return isTie

    function isColTie() returns boolean
        isColTie = false
        for each col in COL
            origin = board[0][col]
            tieCount = 0
            for each row in ROW
                if board[row][col] not equals origin
                    tieCount = tieCount + 1
            if tieCount equals 3
                isColTie = true
        return isColTie

    function isRowTie() returns boolean
        isRowTie = false
        for each row in ROW
            origin = board[row][0]
            tieCount = 0
            for each col in COL
                if board[row][col] not equals origin
                    tieCount = tieCount + 1
            if tieCount equals 3
                isRowTie = true
        return isRowTie

    function isDiagonalTie() returns boolean
        isDiagonalTie = false
        tieRight = false
        tieLeft = false
        originLeft = board[0][0]
        originRight = board[2][0]
        if board[1][1] not equals originRight or board[0][2] not equals originRight
            tieRight = true
        if board[1][1] not equals originLeft or board[2][2] not equals originLeft
            tieLeft = true
        if tieLeft and tieRight
            isDiagonalTie = true
        return isDiagonalTie

    function main()
        count = 0
        playAgain = true
        while playAgain
            clearBoard()
            display()
            repeat
                repeat
                    input xMove
                    input yMove
                    xMove = xMove - 1
                    yMove = yMove - 1
                until isValidMove(yMove, xMove)
                if count mod 2 equals 0
                    board[yMove][xMove] = "O"
                    player ← "O"
                else
                    board[yMove][xMove] = "X"
                    player = "X"
                display()
            until isWin(player) or isTie()
            player ← ""
            count ← 0
            playAgain ← inputYNConfirm("Do you want to play again? ")
    */

    private static int count = 0;
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int xMove;
        int yMove;
        //Stores what letter was last played
        String player;

        boolean playAgain;
        do {
            //Clear Board
            clearBoard();
            //Display Board
            display();

            //Output ask for next move/Input Player Move Choice (Loop until valid move)
            do {
                do {
                    //Input for player move
                    xMove = SafeInput.getRangedInt(in, "What is your X coordinate? (Origin is a top left) ", 1, 3);
                    yMove = SafeInput.getRangedInt(in, "What is your Y coordinate? (Origin is a top left) ", 1, 3);

                    //Convert Player Move Choice
                    xMove = xMove - 1;
                    yMove = yMove - 1;
                } while (!isValidMove(yMove, xMove)); //yMove comes first because y indicates which row
                //Determine whether move was for X or O
                if (count % 2 == 0) {
                    board[yMove][xMove] = "O"; //yMove comes first because y indicates which row
                    player = "O";
                } else {
                    board[yMove][xMove] = "X"; //yMove comes first because y indicates which row
                    player = "X";
                }
                //Display Move
                display();
            } while(!isWin(player) && !isTie());

            //Reset variables
            player = "";
            count = 0;

            //Prompt to play again
            playAgain = SafeInput.getYNConfirm(in, "Do you want to play again? ");
        } while(playAgain);

    }

    //Clears the board
    private static void clearBoard()
    {
        //Set all values in board to spaces
        for(int row = 0; row < ROW; row++) {    //For each row
            for (int col = 0; col < COL; col++)     //For each col
            {
              board[row][col] = " ";    //Set values in board to empty
            }
            System.out.println();
        }
    }

    //Prints the board
    private static void display()
    {
        //Print all values in board
        for(int row = 0; row < ROW; row++)  //for each row
        {
            for (int col = 0; col < COL; col++)     //for each col
            {
                //Prints value in baord
                System.out.print(board[row][col]);

                //Makes it so | is not printed a 3rd time
                if(col < 2)
                {
                    System.out.print(" | ");
                }
            }
            System.out.println();

            //Makes it so ---- is not printed a 3rd time
            if(row < 2)
            {
                //Prints out all ---- in a line
                for (int dash = 0; dash < 9; dash++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    //Checks if move is possible
    private static boolean isValidMove(int row, int col)
    {
        boolean isValidMove = false;
        //Check if new move index has not already been used

        // If the spot is empty then it is a valid move
        if(board[row][col].equals(" "))
        {
            isValidMove = true;
            count = count + 1;
        }

        //Move is not valid!
        if(!isValidMove)
        {
            System.out.println("That spot is already taken! ");
        }
        return isValidMove;
    }

    //Checks for win
    private static boolean isWin(String player)
    {
        boolean isWin = false;

        //If any type of win is true then so is isWin
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player) && count >= 5)
        {
            isWin = true;
            System.out.println("Player " +player +" wins!");
        }

        return  isWin;
    }

    //Checks for wins in col
    private static boolean isColWin(String player)
    {
        boolean isColWin = false;

        for(int col = 0; col < COL; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                isColWin = true;
            }
        }

        return isColWin;
    }

    //Checks for wins in row
    private static boolean isRowWin (String player)
    {
        boolean isRowWin = false;

        for(int row = 0; row < COL; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                isRowWin = true;
            }
        }

        return isRowWin;
    }

    //Checks for win in diagonals
    private static boolean isDiagonalWin(String player)
    {
        boolean isDiagonalWin = false;

        //Diagonal top left to bottom right
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            isDiagonalWin = true;
        }

        //Diagonal bottom left to top right
        if(board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player))
        {
            isDiagonalWin = true;
        }

        return isDiagonalWin;
    }

    //Checks for ties
    private static boolean isTie()
    {
        boolean isTie = false;

        //If there is no possible win then isTie = true
        if(isColTie() && isRowTie() && isDiagonalTie() && count >= 7)
        {
            isTie = true;
            System.out.println("It's a tie!");
        }

        return isTie;
    }

    //Checks for col ties
    private static boolean isColTie()
    {
        boolean isColTie = false;
        String origin;
        int tieCount = 0;

        //for each col
        for(int col = 0; col < COL; col++)
        {
           //finds whether first spot is x or o then compares to next spots
           origin = board[0][col];
           if(!board[1][col].equals(origin) || !board[2][col].equals(origin))
           {
                tieCount = tieCount + 1;
           }

           if(tieCount == 3)
           {
               isColTie = true;
           }
        }

        return isColTie;
    }

    //Checks for row ties
    private static boolean isRowTie()
    {
        boolean isRowTie = false;
        String origin;
        int tieCount = 0;

        //for each row
        for(int row = 0; row < ROW; row++) {
            //finds whether first spot is x or o then compares to next spots
            origin = board[row][0];
            if (!board[row][1].equals(origin) || !board[row][2].equals(origin)) {
                tieCount = tieCount + 1;
            }

            if (tieCount == 3) {
                isRowTie = true;
            }
        }
        return isRowTie;
    }

    //Checks for ties in diagonal
    private static boolean isDiagonalTie()
    {
        boolean isDiagonalTie = false;
        boolean tieRight = false;
        boolean tieLeft = false;
        String originLeft = board[0][0];
        String originRight = board[2][0];

        //First diagonal
        if(!board[1][1].equals(originRight) || !board[0][2].equals(originRight))
        {
            tieRight = true;
        }

        //Second diagonal
        if(!board[1][1].equals(originLeft) || !board[2][2].equals(originLeft))
        {
            tieLeft = true;
        }

        if(tieLeft && tieRight)
        {
            isDiagonalTie = true;
        }

        return isDiagonalTie;
    }
}