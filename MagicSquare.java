



public class MagicSquare implements MagicSquareInterface {

    private int[][] Matrix;


    public MagicSquare(int n) {
        
        
        Matrix = new int[n][n];
        for (int r = 0;r < n;r++) {           //loop goes to each individual location in the grid 
            for (int c=0;c<n; c++) {
            }
        }
    }


    @Override
    public boolean isMagicSquare() {
        int magicNumber = Matrix.length * (Matrix.length*Matrix.length + 1) / 2;
        int magicSum = 0;

        for (int r = 0;r < Matrix.length;r++) {           //loop goes to each individual location in the grid 
            for (int c=0;c<Matrix.length; c++) {
                magicSum += Matrix[r][c];
            }
        }

        if (magicNumber == magicSum) {
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public int[][] getMatrix() {
        int[][] copyMatrix = new int[Matrix.length][Matrix.length]; // creates a copy of the matrix with the right dimensions
        
        for (int r = 0;r < Matrix.length;r++) {           //loop goes to each individual location in the grid 
            for (int c=0;c<Matrix.length; c++) {
                copyMatrix[r][c] = Matrix[r][c];
            }
        }
        
        return copyMatrix;

    }

    @Override
	public String toString() {
        String magicString = " The matrix\n";
        for (int r = 0;r < Matrix.length;r++) {  
            magicString += "   ";
            for (int c=0;c<Matrix.length; c++) {
                magicString += Matrix[r][c];
            }
            magicString += "\n";
        }
        if () {

        }
        else{
            
        }


}
