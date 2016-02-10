/**
 * This class extends the Abstract Class MagicSquare
 *
 * This completes the functionality for generation of
 * an Odd size Magic Square
 */
public class OddSquare extends MagicSquare
{
    /**
     * Field to hold the size of the Matrix
     */
    public int size = -1;

    /**
     * Implementation of the abstract method solveMagicSquare()
     *
     * This generates the Magic Square for an Odd Size
     */
    @Override
    public void solveMagicSquare(int[][] magicSquare)
    {
        /*
            Following the up and right method mentioned on Wikipedia

            https://en.wikipedia.org/wiki/Magic_square#Method_for_constructing_a_magic_square_of_odd_order

            Code wraps around the matrix when required

            The values of row and col are calculated starting from the center of first row
         */
        int col = size/2;
        int row = size-1;
        magicSquare[row][col] = 1;
        for (int i = 2; i <= size*size; i++)
        {
            if (magicSquare[(row + 1) % size][(col + 1) % size] == 0)
            {
                row = (row + 1) % size;
                col = (col + 1) % size;
            }
            else
            {
                row = (row - 1 + size) % size;
            }
            magicSquare[row][col] = i;
        }
    }
}