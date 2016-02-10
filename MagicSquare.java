import java.util.Arrays;

/**
 * This abstract class implements the interface and adds
 * the functionality for initMagicSquare() and
 * displayMagicSquare()
 *
 * The class leaves solveMagicSquare() as an abstract
 * method and lets the individual classes define
 * it's behaviour
 */

public abstract class MagicSquare implements SquareInterface
{
    public void initMagicSquare(int[][] magicSquare)
    {
        for(int[] row: magicSquare)
        {
            Arrays.fill(row, 0);
        }
    }

    public abstract void solveMagicSquare(int[][] magicSquare);

    public void displayMagicSquare(int[][] magicSquare)
    {
        int size = magicSquare[0].length;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(magicSquare[i][j]+"\t");
            }
            System.out.println();
        }
    }
}