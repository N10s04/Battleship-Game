package battleship;

public class Grid extends Location
{
    /*
    * represents a battleship grid for the user and computer
    * tracks ships
    * tracks guesses by user and computer
    * main state to track is 2d array of location objects
     */

    //static variables
    public static final int NUM_ROWS = 11;
    public static final int NUM_COLS = 11;

    //instance variables
    //private Location[][] grid = new Location[NUM_ROWS][NUM_COLS];
    private Location[][] grids;


    //create a new grid object
        //initialize locations in the grid to be location objects
    public Grid()
    {
        super();
        grids = new Location[NUM_ROWS][NUM_COLS];
        //creates a new grid object, holds location object
        for (int r = 0; r < NUM_ROWS; r++)
        {
            for (int c = 0; c < NUM_COLS; c++)
            {
                //this took me forever to figure out...

                //initialize the location as a Location
                grids[r][c] = new Location();
                //set the status of the Location at the location
                grids[r][c].setStatus(Location.UNGUESSED);
            }
        }
    }

    //mark a hit
        //call the markHit on the location
    public void markHit(int row, int col)
    {
        grids[row][col].markHit();
        grids[row][col].setStatus(2);
    }
    //mark a miss
        //call markMiss on the location
    public void markMiss(int row, int col)
    {
        grids[row][col].markMiss();
        grids[row][col].setStatus(1);
    }

    //set status of location
    public void setStatus(int row, int col, int status)
    {
        grids[row][col].setStatus(status);
    }

    //get status of location
    public int getStatus(int row, int col)
    {
        return grids[row][col].getStatus();
    }

    //check if location already guessed or not
    public boolean alreadyGuessed(int row, int col)
    {
        return !(grids[row][col].isUnguessed());
    }

    //set whether or not there is a ship at this location to the val
    public void setShip(int row, int col, boolean val)
    {
        grids[row][col].setShip(val);
    }

    //check if there is a ship there
    public boolean hasShip(int row, int col)
    {
        return grids[row][col].hasShip();
    }

    //get the location object at this row and column
    public Location get(int row, int col)
    {
        return grids[row][col];
    }

    //return the number of rows in the grid
    public int numRows()
    {
        return NUM_ROWS;
    }
    //return the number of columns in the grid
    public int numCols()
    {
        return NUM_COLS;
    }


    /*
    Print the Grid status including a header at the top
    that shows the columns 1-10 as well as letters across
    the side for A-J
    If there is no guess print a -
    If it was a miss print a O
    If it was a hit, print an X
    A sample print out would look something like this:

       1 2 3 4 5 6 7 8 9 10
     A - - - - - - - - - -
     B - - - - - - - - - -
     C - - - O - - - - - -
     D - O - - - - - - - -
     E - X - - - - - - - -
     F - X - - - - - - - -
     G - X - - - - - - - -
     H - O - - - - - - - -
     I - - - - - - - - - -
     J - - - - - - - - - -
    */
    public void printStatus()
    {
        char currentRow = 'A';

        //print the numbers at the top
        System.out.print(" ");
        for(int i = 1; i<=10; i++)
        {
            System.out.print(" " + i);
        }

        System.out.println();

        for (int r = 1; r < NUM_ROWS; r++)
        {
            //print the row letter
            System.out.print(currentRow + " ");
            currentRow++;

            for (int c = 1; c < NUM_COLS; c++)
            {
                if (grids[r][c].checkHit())
                {
                    System.out.print("O ");
                }
                else if (grids[r][c].checkMiss())
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    /*
    Print the grid and whether there is a ship at each location.
    If there is no ship, you will print a - and if there is a
    ship you will print a X. You can find out if there was a ship
    by calling the hasShip method.

       1 2 3 4 5 6 7 8 9 10
     A - - - - - - - - - -
     B - X - - - - - - - -
     C - X - - - - - - - -
     D - - - - - - - - - -
     E X X X - - - - - - -
     F - - - - - - - - - -
     G - - - - - - - - - -
     H - - - X X X X - X -
     I - - - - - - - - X -
     J - - - - - - - - X -
     */
    public void printShips()
    {
        char currentRow = 'A';

        //print the numbers at the top
        System.out.print(" ");
        for(int i = 1; i<=10; i++)
        {
            System.out.print(" " + i);
        }

        System.out.println();

        for (int r = 1; r < NUM_ROWS; r++)
        {
            //print the row letter
            System.out.print(currentRow + " ");
            currentRow++;

            for (int c = 1; c < NUM_COLS; c++)
            {
                if (grids[r][c].hasShip())
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

//-=-=-=-=-=-

    /**
     * This method can be called on your own grid. To add a ship
     * we will go to the ships location and mark a true value
     * in every location that the ship takes up.
     */
    public void addShip(Ship s, String loopNeeded, int column, int row)
    {
        //want to add a ship to the location in the grid
        //will need to call the setStatus method

        int length = s.getLength();

        //reverse loop (right to left)
        if (loopNeeded.equals("RL"))
        {
            for (int c = column; c > column - length; c--)
            {
                setShip(row, c, true);
                grids[row][c].setShip(true);
            }
        }

        //normal loop (left to right)
        if (loopNeeded.equals("LR"))
        {
            for (int c = column; c < length + column; c++)
            {
                setShip(row, c, true);
                grids[row][c].setShip(true);
            }
        }

        //reverse loop (bottom to top)
        if (loopNeeded.equals("BT"))
        {
            for (int r = row; r > row - length; r--)
            {
                setShip(r, column, true);
                grids[r][column].setShip(true);
                System.out.println("reverse vertical loop!");
            }
        }

        //normal loop (top to bottom)
        if (loopNeeded.equals("TB"))
        {
            for (int r = row; r < length + row; r++)
            {
                setShip(r, column, true);
                grids[r][column].setShip(true);
                System.out.println("normal vertical loop!");
            }
        }
    }

    /*
     * need to combine the checking part of addShip() and spaceAvailable
     * so that I can check for empty spaces by checking in the right, up, left, and down directions
     * for both ship presence and if the current ship will even fit
     * if it can fit, decide which direction (right/left for horizontal and up/down for vertical) to place it in
     * throw an error for when the ship cannot fit
     */

    public boolean willItFit(Ship s, int row, int col, int dir)
    {
        int length = s.getLength();
        int spaceNeeded = length;
        String loopNeeded = "";
        boolean shipFits = false;
        boolean canBePlaced = false;
        int rlCounter = 0;
        int lrCounter = 0;
        int tbCounter = 0;
        int btCounter = 0;

        //check if the ship will fit
        if (dir == 0) //horizontal ship
        {
            if (length - col < 0) //will it fit?
            {
                //place the ship right to left
                loopNeeded = "RL";
            }
            else
            {
                //place the ship left to right
                loopNeeded = "LR";
            }
            shipFits = true;
        }
        else if (dir == 1) //vertical ship
        {
            if (length - row < 0)
            {
                //place the ship top to bottom
                loopNeeded = "TB";
            }
            else
            {
                //place the ship bottom to top
                loopNeeded = "BT";
            }
            shipFits = true;
        }

        //check if the ship can be placed
        if (dir == 0) //horizontal ship
        {
            for (int l = col; l > col - spaceNeeded; l--) //checking right to left
            {
                if (!(grids[row][Math.abs(l)].hasShip()))
                {
                    //if the space available right to left matches the spaceNeeded, then place the ship right to left
                    rlCounter++;
                }
                if (rlCounter == spaceNeeded)
                {
                    canBePlaced = true;
                    break;
                }
            }
            for (int r = col; r < col + spaceNeeded; r++) //checking left to right
            {
                if (!(grids[row][r].hasShip()))
                {
                    //if the space available left to right matches the spaceNeeded, then place the ship left to right
                    lrCounter++;
                }
                if (lrCounter == spaceNeeded)
                {
                    canBePlaced = true;
                    break;
                }
            }
        }
        else if (dir == 1) //vertical ship
        {
            for (int u = row; u > row - spaceNeeded; u--) // checking bottom to top
            {
                if (!(grids[u][col].hasShip()))
                {
                    //if the space available bottom to top matches the spaceNeeded, then place the ship bottom to top
                    btCounter++;
                }
                if (btCounter == spaceNeeded)
                {
                    canBePlaced = true;
                    break;
                }
            }
            for (int d = row; d < row + spaceNeeded; d++) //checking top to bottom
            {
                if (!(grids[d][col].hasShip()))
                {
                    //if the space available top to bottom matches the spaceNeeded, then place the ship top to bottom
                    tbCounter++;
                }
                if (tbCounter == spaceNeeded)
                {
                    canBePlaced = true;
                    break;
                }
            }
        }

        //check if the ship will fit and can be placed
        if (shipFits && canBePlaced)
        {
            addShip(s, loopNeeded, col, row);
            return true;
        }
        else
        {
            return false;
        }
    }
}
