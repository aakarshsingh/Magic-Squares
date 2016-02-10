/**
 * This class extends the Abstract Class MagicSquare
 *
 * This completes the functionality for generation of
 * a Double Even size Magic Square
 */
public class DoubleEvenSquare extends MagicSquare
{
    /**
     * Field to hold the size of the Matrix
     */
    public int size = -1;

    /**
     * Implementation of the abstract method solveMagicSquare()
     *
     * This generates the Magic Square for a DoubleEven Size
     */
    @Override
    public void solveMagicSquare(int[][] magicSquare)
    {
        /*
            Using the logic mentioned here

            http://www.1728.org/magicsq2.htm

            The code uses two values count and revCount, which starts from 1 and N respectively

            According to the location or the sub-Square we are in the Matrix, the correct value is
            applied to the location
         */
        int insideSquares = size / 4;
        int count = 1;
        int revCount = size * size;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (j >= insideSquares && j < size - insideSquares)
                {
                    if (i >= insideSquares && i < size - insideSquares)
                    {
                        magicSquare[i][j] = count;
                    }
                    else
                    {
                        magicSquare[i][j] = revCount;
                    }
                }
                else if (i < insideSquares || i >= size - insideSquares)
                {
                    magicSquare[i][j] = count;
                }
                else
                {
                    magicSquare[i][j] = revCount;
                }
                count++;
                revCount--;
            }
        }
    }
}
