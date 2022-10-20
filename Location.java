package battleship;

public class Location
{
    /*
    * stores the location for a single grid position
    * a location has two attributes:
    *   - is there a ship at this location?
    *   - what is the status of this location?
    * status is whether the position is:
    *   - unguessed
    *   - hit
    *   - miss
    * statuses will be static variables
     */

    //static variables for statuses
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;

    //instance variables
    private boolean shipPresence = false;
    private int shipStatus = UNGUESSED;

    //location constructor
    public Location()
    {
        //stuff
    }

    //hit checker
    public boolean checkHit()
    {
        if (shipStatus == HIT)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //miss checker
    public boolean checkMiss()
    {
        if (shipStatus == MISSED)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //unguessed checker
    public boolean isUnguessed()
    {
        if (shipStatus == UNGUESSED)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //mark as hit
    public void markHit()
    {
        shipStatus = HIT;
    }
    //mark as miss
    public void markMiss()
    {
        shipStatus = MISSED;
    }

    //check for presence of a ship
    public boolean hasShip()
    {
        return shipPresence;
    }

    //set the presence of a ship
    public void setShip(boolean val)
    {
        shipPresence = val;
    }
    //set the status of the location
    public void setStatus(int status)
    {
        shipStatus = status;
    }

    //get the status of the location
    public int getStatus()
    {
        return shipStatus;
    }

}
