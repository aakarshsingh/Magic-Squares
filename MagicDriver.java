import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is a Driver Class
 *
 * It creates the correct Object based on the input
 * and calls the solveMagicSquare method
 */
public class MagicDriver
{
    /**
     * This is the main method
     *
     * This method also calculates the Magic Constant and displays it after returning
     * to the flow after generation of the Magic Square
     *
     * @param args These are the command line parameters
     * @exception InputMismatchException This is thrown when the user doesn't enter an Integer
     *
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of Square: ");
        int size=-1;
        try
        {
            size = in.nextInt();
            in.close();
        }
        catch (InputMismatchException e)
        {
            System.err.println("Invalid Input. Please enter an Integer");
            System.exit(0);
        }
        if(size <= 0 || size==2) //There are no magic squares for size 2
        {
            System.err.println("Invalid Size");
            System.exit(0);
        }
        else if(size%2 == 1)
        {
            int[][] magicSquare = null;
            magicSquare = new int[size][size];
            OddSquare oddSquare = new OddSquare();
            oddSquare.initMagicSquare(magicSquare);
            oddSquare.size = size;
            oddSquare.solveMagicSquare(magicSquare);
            oddSquare.displayMagicSquare(magicSquare);
        }
        else if(size%4 == 0)
        {
            int[][] magicSquare = null;
            magicSquare = new int[size][size];
            DoubleEvenSquare doubleEvenSquare = new DoubleEvenSquare();
            doubleEvenSquare.initMagicSquare(magicSquare);
            doubleEvenSquare.size = size;
            doubleEvenSquare.solveMagicSquare(magicSquare);
            doubleEvenSquare.displayMagicSquare(magicSquare);
        }
        else
        {
            int[][] magicSquare = null;
            magicSquare = new int[size][size];
            EvenSquare evenSquare = new EvenSquare();
            evenSquare.initMagicSquare(magicSquare);
            evenSquare.size = size;
            evenSquare.solveMagicSquare(magicSquare);
            evenSquare.displayMagicSquare(magicSquare);
        }
        System.out.println("Magic Constant = "+((size * ((size * size) + 1)) >> 1));
    }
}
