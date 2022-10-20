package battleship;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        /* ****************************************** */
        //Some notes
        //this scanner class takes user input because codeHS
        //uses its own user input system :(
        //I primarily wrote this in the IntelliJ IDEA IDE
        //The computer doesn't have any smarts and randomly picks points
        //although I would like to add a class in which it
        //takes the previous Hit and hits +1 in each direction from it
        //Player health is the net Ship health, 17
        //although I will base the health off of individual ship
        //health later on
        //Ships will over lap due to length. I couldn't get it working.
        //see spaceAvailable() in the Grid class for the broken code
        //also, the computer is allowed to overlap ships by coordinate by the user can't
        //because I forgot to give the computer that functionality

        Scanner reader = new Scanner(System.in);

        /* ****************************************** */


        /*
         * create two player objects
         * be able to print out the current board status they have
         * make a guess
         * update the underlying data structure
         * show changes in the display
         * need a class called askForGuess to ask the player for a row and col guess, if there is as ship, it should say so
         */

        Player p1;
        Player p2;
        Ship currentShip;
        int currentShipLength;
        int row = 0;
        int col = 0;
        int dir = Ship.UNSET;
        int randRow;
        int randCol;
        int randDir;
        int counter = 0;

        //players
        p1 = new Player(); //the user
        p2 = new Player(); //the computer

        Player currentPlayer = p1; //p1 goes first
        Player nextPlayer = p2; //then p2

        //player health setup -- will make this per-ship later
        int p1Health = Player.FULL_HEALTH;
        int p2Health = Player.FULL_HEALTH;
        String cp = "";

        //these two initial ships are to prevent overlapping; they take advantage of a thing I can't seem to fix
        Ship initialShip = new Ship(1);
/*        p1.chooseShipLocation(initialShip, row, col, 1);
        p2.chooseShipLocation(initialShip, row, col, 1);*/
        p1.setShip(row, col, true);
        p2.setShip(row, col, true);

        //set up for p1 -- can move this and set up for computer to own method later
        p1.printMyShips();
        for (int i = 0; i < 5; i++)
        {
            currentShipLength = Player.SHIP_LENGTHS[i];
            currentShip = new Ship(currentShipLength);

            //prompting for where to place the ships
            System.out.println("\nNow placing ship of length " + currentShipLength);
            System.out.println("Please choose a row: ");
            row = reader.nextInt();
            System.out.println("Please choose a column: ");
            col = reader.nextInt();
            System.out.println("Please choose a direction: ");
            dir = reader.nextInt();
/*
            //to prevent overlapping ships...
            //while there is a ship at the desired row and column, prompt the user to enter a row and column
            //the board has a weird (0, 0) location I can't get rid of, so I'll initially set row and col to 0
            //and make the user change them with the prompts
            //add to this while loop to account for while space is not available in the desired direction

            //this is now obsolete code, the system was remade june 1
            while (p1.grid_1.hasShip(row, col) || (!(p1.grid_1.spaceAvailable(row, col, currentShip))))
            {
                System.out.println("\nThere is already a ship at (" + row + ", " + col + ")" );

                //prompting for where to place the ships
                System.out.println("\nNow placing ship of length " + currentShipLength);
                System.out.println("Please choose a row: ");
                row = reader.nextInt();
                System.out.println("Please choose a column: ");
                col = reader.nextInt();
                System.out.println("Please choose a direction: ");
                dir = reader.nextInt();
            }
            if (!(p1.grid_1.hasShip(row, col)))
            {
                //actually place the ships
                p1.chooseShipLocation(currentShip, row, col, dir);
                p1.setShip(row, col, true);

                System.out.println("\nPlayer 1's Current Ship Board");
                p1.printMyShips();
            }*/

            //call willItFit
            //if it returns true (will fit), the function automatically placed the ship in the desired location
            //if it returns false (will not fit), use a while loop to continually ask the questions until a valid location is given
            p1.willItFit(currentShip, row, col, dir);
            /*if (!p1.willItFit(currentShip, row, col, dir))
            {
                while (!(p1.willItFit(currentShip, row, col, dir)))
                {
                    System.out.println("\nThere is already a ship at (" + row + ", " + col + ")");

                    //prompting for where to place the ships
                    System.out.println("\nNow placing ship of length " + currentShipLength);
                    System.out.println("Please choose a row: ");
                    row = reader.nextInt();
                    System.out.println("Please choose a column: ");
                    col = reader.nextInt();
                    System.out.println("Please choose a direction: ");
                    dir = reader.nextInt();
                }
            }
            p1.chooseShipLocation(currentShip, row, col, dir);
            p1.setShip(row, col, true);*/
            System.out.println("Successfully placed new ship of length " + currentShipLength + " at (" + row + ", " + col + ")");
            System.out.println("\nPlayer 1's Current Ship Board");
            p1.printShips();
        }

        //set up for computer
        /*for (int i = 0; i < 5; i++)
        {
            currentShipLength = Player.SHIP_LENGTHS[i];
            currentShip = new Ship(currentShipLength);

            randRow = Randomizer.nextInt(1, 10);
            randCol = Randomizer.nextInt(1, 10);
            randDir = Randomizer.nextInt(0, 1);

            //prevent overlapping ships
            while (p2.grid_1.hasShip(row, col))
            {
                randRow = Randomizer.nextInt(1, 10);
                randCol = Randomizer.nextInt(1, 10);
                randDir = Randomizer.nextInt(0, 1);
            }
            if (!(p2.grid_1.hasShip(row, col)))
            {
                //actually place the ships
                p2.chooseShipLocation(currentShip, randRow, randCol, randDir);
                p2.setShip(row, col, true);
            }
        }*/

        //main fight loop
        //while both players have totalHealth greater than 0
        {
            //show currentPlayer's grid2
            //ask currentPlayer for a guess
            //print currentPlayer's guess to the screen
            //call recordOpponentGuess with currentPlayer's desired row and column
            //print if it was a hit or a miss to the screen
            //if hit, update the status of that location to be hit, decrease totalHealth by 1 point
            //if miss, update the status of that location to be miss
            //show currentPlayer's grid1
            //if currentPlayer is p1, change nextPlayer to p2
            //change currentPlayer to nextPlayer, change nextPlayer to p1
        }

        //keep playing until someone is out of ships
        while (p1.getHealth() > 0 && p2.getHealth() > 0)
        {
            if (currentPlayer == p1)
            {
                System.out.println("\nPlayer 1's turn");
                cp = "Player 1";
                nextPlayer = p2;

                //the human's turn
                //ask the current player for a target row and a target column

            }
            else
            {
                System.out.println("\nPlayer 2's turn");
                cp = "Player 2";
                nextPlayer = p1;
            }

            // dealing with player health
            p1Health = p1.getHealth();
            p2Health = p2.getHealth();
            printHealthStatus(p1Health, p2Health);

            //display the current player's top grid (their guesses) and bottom grid (their ships' statuses)
            //printBoards(cp, currentPlayer);       //this will show boards for both the human and the computer
            if (currentPlayer == p1)
            {
                printBoards("Player 1", p1);        //this will only show the human's boards
            }


            //ask the current player for a target row and a target column
            //but if it's the computer's turn, pick for them
            askForGuess(currentPlayer, nextPlayer, p1, p2);

            //advance the game by setting up the next player and asking to continue to the next turn
            currentPlayer = nextPlayer;
            System.out.println("\nWould you like to keep playing? (y/n): ");
            String ready = reader.next();
            if (ready.equals("y"))
            {
                counter++;
                System.out.println("-=-=-=-=-=-");
                System.out.println("\n\n\nRound " + counter);
            }
            else
            {
                break;
            }
        }

        //end of game!
        if (p1Health > p2Health)
        {
            System.out.println("\nPLAYER 1 WINS!");
            System.out.println("Thanks for playing!");
        }
        else if (p2Health > p1Health)
        {
            System.out.println("\nPLAYER 2 WINS!");
            System.out.println("Thanks for playing!");
        }
        else
        {
            System.out.println("\nTIE!");
            System.out.println("Thanks for playing!");
        }

    }

    public static void printHealthStatus(int p1Health, int p2Health)
    {
        System.out.println();
        System.out.println("\np1 health is " + p1Health);
        System.out.println("\np2 health is " + p2Health);
        System.out.println();
    }

    public static void printBoards(String cp, Player currentPlayer)
    {
        System.out.println("\n" + cp + "'s guesses");
        currentPlayer.printMyGuesses();
        System.out.println("\n" + cp + "'s board");
        currentPlayer.printOpponentGuesses();
    }

    public static void askForGuess(Player currentPlayer, Player nextPlayer, Player p1, Player p2)
    {
        /* see the note at the top for why this is here */
        Scanner reader = new Scanner(System.in);

        int targetRow;
        int targetCol;

        //only prompt if its the human's turn
        if (currentPlayer == p1)
        {
            System.out.println("\nTarget a row: ");
            targetRow = reader.nextInt();
            System.out.println("Target a column: ");
            targetCol = reader.nextInt();
        }
        //and if it's the computer's turn...
        else
        {
            targetRow = Randomizer.nextInt(1, 10);
            targetCol = Randomizer.nextInt(1, 10);

            System.out.println("\nComputer targets " + targetRow + ", " + targetCol);
        }

        //fire!! but only if the location is unguessed...
        if (currentPlayer.getStatus(targetRow, targetCol) == Location.UNGUESSED)
        {
            if (nextPlayer.recordOpponentGuess(targetRow, targetCol, currentPlayer, p1, p2))
            {
                nextPlayer.setHealth(nextPlayer.getHealth() - 1);
            }
        }
        else
        {
            System.out.println("\nYou've already guessed that spot. Next turn.");
        }
    }
}
