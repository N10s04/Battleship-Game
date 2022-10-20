package battleship;
public class Ship
{
    /*
     * representing a ship in the game
     * has attributes:
     *  - row
     *  - column (col)
     *  - length (len)
     *  - direction (dir)
     * ships of lengths:
     *  - 2, 3, 3, 4, 5
     * rows
     *  - A-J
     * columns
     *  - 1-10
     * directions
     *  - vertical (v)
     *  - horizontal (h)
     */

    //constant variables for direction
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;


    //instance variables for row, col, len, and dir
    private int row = UNSET;
    private int col = UNSET;
    private int length = UNSET;
    private int direction = UNSET;

    //constructor
    public Ship(int myLen)
    {
        length = myLen;
    }

    //two methods to check if location and direction are set
    public boolean isLocationSet()
    {
        if(row != UNSET && col != UNSET)
        {
            return true;
        }
        else
        {
            row = UNSET;
            col = UNSET;
            return false;
        }
    }
    public boolean isDirectionSet()
    {
        if(direction == HORIZONTAL || direction == VERTICAL)
        {
            return true;
        }
        else
        {
            direction = UNSET;
            return false;
        }
    }

    //set the location of the ship, take in row and col
    public void setLocation(int myRow, int myCol)
    {
        row = myRow;
        col = myCol;
    }
    //set the direction of the ship, take in dir as a char (h/v)
    public void setDirection(int myDir)
    {
        direction = myDir;
    }

    //get the row, col, len, and dir
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
    public int getLength()
    {
        return length;
    }
    public int getDirection()
    {
        return direction;
    }

    //couple of toString methods for the current ship object, direction, and location
    public String toString()
    {
        return directionToString() + "ship of length " + length + " at " + locationToString();
    }
    private String directionToString()
    {
        if (direction == VERTICAL)
        {
            return "vertical ";
        }
        else if (direction == HORIZONTAL)
        {
            return "horizontal ";
        }
        else
        {
            return "unset direction ";
        }

    }
    private String locationToString()
    {
        if (row == UNSET || col == UNSET)
        {
            return "(unset location)";
        }
        else
        {
            return String.format("(%s, %s)", row, col);
        }
    }
}
