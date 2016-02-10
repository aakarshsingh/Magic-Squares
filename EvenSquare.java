/**
 * This class extends the Abstract Class MagicSquare
 *
 * This completes the functionality for generation of
 * a Even size Magic Square
 */
public class EvenSquare extends MagicSquare
{
    /**
     * Field to hold the size of the Matrix
     */
    public int size = -1;

    /**
     * Implementation of the abstract method solveMagicSquare()
     *
     * This generates the Magic Square for an Even Size
     */
    @Override
    public void solveMagicSquare(int[][] magicSquare)
    {
        /*
            This uses the logic mentioned on http://www.1728.org/magicsq3.htm

            The code divides the matrix into four sections A, B, C, D

            The sections are arranged as

                A   C
                D   B

            The first section is nothing but an Odd Magic Square of size = N/2

            The other sections are A[i] + (N/2)*(N/2)

            We are using the code from the OddSquare class to generate the A sub-square

            After generation of A,B,C,D we need to swap some values
         */
        int oddSize = size/2;

        /*
            Calling the OddSquare to help with the EvenSquare
         */
        int[][] helperMagicSquare = null;
        helperMagicSquare = new int[oddSize][oddSize];
        OddSquare oddSquare = new OddSquare();
        oddSquare.initMagicSquare(helperMagicSquare);
        oddSquare.size = oddSize;
        oddSquare.solveMagicSquare(helperMagicSquare);

        for(int i=0; i<oddSize; i++)
        {
            for(int j=0; j<oddSize; j++)
            {
                /*
                    Filling the 4 boxes according to the identified logic mentioned above
                 */
                magicSquare[i][j] = helperMagicSquare[i][j];    //Box A
                magicSquare[i+oddSize][j+oddSize] = helperMagicSquare[i][j]+(oddSize*oddSize);    //Box B
                magicSquare[i][j+oddSize] = helperMagicSquare[i][j]+(2*(oddSize*oddSize));    //Box C
                magicSquare[i+oddSize][j] = helperMagicSquare[i][j]+(3*(oddSize*oddSize));    //Box D
            }
        }
        /**
         * stores the values of the columns which needs to be swapped
         */
        int swapIndices[] = new int[size];
        int shift=(size-2)/4;
        int arrayIndex = 0;

        for (int i=0; i<shift; i++)
        {
            swapIndices[arrayIndex++] = i;
        }

        for (int i=size-shift+1; i<size; i++)
        {
            swapIndices[arrayIndex++] = i;
        }

        /*
            General logic for swapping
         */
        for(int i=0; i<oddSize; i++)
        {
            for(int j=0; j<arrayIndex; j++)
            {
                magicSquare[i][swapIndices[j]] = magicSquare[i][swapIndices[j]] ^ magicSquare[i+oddSize][swapIndices[j]];
                magicSquare[i+oddSize][swapIndices[j]] = magicSquare[i][swapIndices[j]] ^ magicSquare[i+oddSize][swapIndices[j]];
                magicSquare[i][swapIndices[j]]= magicSquare[i][swapIndices[j]] ^ magicSquare[i+oddSize][swapIndices[j]];
            }
        }

        /*
            Swapping outliers
         */

        magicSquare[shift][0] = magicSquare[shift][0] ^ magicSquare[shift+oddSize][0];
        magicSquare[shift+oddSize][0] = magicSquare[shift][0] ^ magicSquare[shift+oddSize][0];
        magicSquare[shift][0] = magicSquare[shift][0] ^ magicSquare[shift+oddSize][0];

        magicSquare[shift][shift] = magicSquare[shift][shift] ^ magicSquare[shift+oddSize][shift];
        magicSquare[shift+oddSize][shift] = magicSquare[shift][shift] ^ magicSquare[shift+oddSize][shift];
        magicSquare[shift][shift] = magicSquare[shift][shift] ^ magicSquare[shift+oddSize][shift];
    }
}
