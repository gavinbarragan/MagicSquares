


import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MagicSquare implements MagicSquareInterface {

    private int[][] Matrix;

    /*
     * Creates MagicSquare one integer.
     */
    public MagicSquare(int n) {
        
        
        Matrix = new int[n][n];
        for (int r = 0;r < n;r++) {           //loop goes to each individual location in the grid 
            for (int c=0;c<n; c++) {
            }
        }
    }

    
    /*
     * Creates MagicSquare using one file param.
     */
    public MagicSquare(String fileName) {
        try {
            File file = new File(fileName);
            Scanner docScanner = new Scanner(file);
            int n = Integer.parseInt(docScanner.next());
            Matrix = new int[n][n];
            Scanner lineScanner;

            //reads each integer into it's spot in  the matrix
            for (int r = 0;r < n;r++) {           
                String line = docScanner.next();
                lineScanner = new Scanner(line);
                for (int c = 0;c < n; c++) {
                    Matrix[r][c] = lineScanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
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
        if (this.isMagicSquare()) {
            magicString += " is a magic square.\n";
        }
        else{
            magicString += " is not a magic square.\n";
        }

        return magicString;


    }
}