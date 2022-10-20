package battleship;

public class Player extends Grid
{
    /*
     * handles the logic for each player -- the user and the pc
     * each player has five ships of set lengths
     * each player has two grids
     *   - one for player 1, other for player 2
     *   - player 1 grid1 marks p1 ships and p2 guesses, grid2 marks p1 guesses
     *   - player 2 grid1 marks p2 ships and p1 guesses, grid2 marks p2 guesses
     *
     */

    //static variables
    public static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    private static final int NUM_SHIPS = 5;
    public static final int FULL_HEALTH = 17;

    //instance variables
    public Grid grid_1;
    public Grid grid_2;
    private int counter = 0;
    private int currentHealth;

    //player constructor
    public Player()
    {
        //each player gets two grids
        grid_1 = new Grid(); //stores the player's SHIPS and opponent's HITS
        grid_2 = new Grid(); //stores the player's GUESSES
        currentHealth = FULL_HEALTH;
    }

    //dealing with player health -- turn this into per-ship later
    public int getHealth()
    {
        return currentHealth;
    }
    public void setHealth(int health)
    {
        currentHealth = health;
    }

    //print the ships on the grid
    public void printMyShips()
    {
        grid_1.printShips();
    }

    //print your guesses
    public void printMyGuesses()
    {
        grid_2.printStatus();
    }
    //print your opponent's guesses
    public void printOpponentGuesses()
    {
        grid_1.printStatus();
    }

    //record the opponent's guess
    public boolean recordOpponentGuess(int row, int col, Player currentPlayer, Player p1, Player p2)
    {
        //need some distinction in player boards...
        if (currentPlayer == p1)
        {
            if (p2.grid_1.hasShip(row, col))
            {
                p2.grid_1.markHit(row, col);
                p1.grid_2.markHit(row, col);
                System.out.println("Hit!");
                return true;
            }
            else
            {
                p1.grid_2.markMiss(row, col);
                System.out.println("Miss!");
                return false;
            }
        }
        else
        {
            if (p1.grid_1.hasShip(row, col))
            {
                p1.grid_1.markHit(row, col);
                p2.grid_2.markHit(row, col);
                System.out.println("Hit!");
                return true;
            }
            else
            {
                p2.grid_2.markMiss(row, col);
                System.out.println("Miss!");
                return false;
            }
        }
    }

    //this method should be obsolete
    //actually placing the ships
    public void chooseShipLocation(Ship s, int row, int col, int direction)
    {
        if (counter <= NUM_SHIPS)
        {
            s.setDirection(direction);
            s.setLocation(row, col);

            this.grid_1.setShip(row, col, true);

            counter++;
        }
    }
}
