/**
 * This application takes a matrix size and
 * generates the Magic Square for that size
 *
 * @author Aakarsh Singh
 * @version 1.0
 * @since 2016-02-10
 */

public interface SquareInterface
{
    /**
     * This method initializes the Matrix with all zeroes
     * @param magicSquare This will contain the Magic Square finally
     */
    public void initMagicSquare(int[][] magicSquare);

    /**
     * This is the method which generates the Magic Square
     * for the given size
     *
     * @param magicSquare This is an empty matrix with zeroes
     *                    The final magic square is stored in this
     *
     */
    public void solveMagicSquare(int[][] magicSquare);

    /**
     * This is a helper function which displays the final Magic Square
     * @param magicSquare This contains the Magic Square
     */
    public void displayMagicSquare(int[][] magicSquare);
}
