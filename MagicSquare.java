


import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MagicSquare implements MagicSquareInterface {

    private int[][] Matrix;
    
    
    /*
     * helping functions for magic square calculation
     */
    private boolean containsAllNumbers() {
        
        boolean containsAllNumbers = true;
        int[] containedNums = new int[Matrix.length*Matrix.length];

        for (int r = 0;r < Matrix.length;r++) {           //loop goes to each individual location in the grid 
            for (int c=0;c<Matrix.length; c++) {
                int checkingNum = Matrix[r][c];
                
                containedNums[checkingNum-1] = checkingNum; //adds each number in the array from the matrix into the array in order
                
            }
        }

        for (int i=0;i<containedNums.length;i++) {
            if (containedNums[i] != i+1) {
                containsAllNumbers = false; //checks that all numbers are included
            }
        }

       return containsAllNumbers;
    }

    private boolean hasMagicPattern() {
        int magicNumber = Matrix.length * (Matrix.length*Matrix.length + 1) / 2;
        boolean hasMagicPattern = true;

        for (int r = 0;r < Matrix.length;r++) {           //checks row sums
            int rowSum = 0;
            for (int c=0;c<Matrix.length; c++) {
                rowSum += Matrix[r][c];
            }
            if (rowSum != magicNumber) {
                hasMagicPattern = false;
            }

        }        

        for (int c = 0;c < Matrix.length;c++) {           //checks col sums
            int colSum = 0;
            for (int r=0;r<Matrix.length; r++) {
                colSum += Matrix[r][c];
            }
            if (colSum != magicNumber) {
                hasMagicPattern = false;
            }

        }   
        
        int diag1sum = 0;
        int diag2sum = 0;
        for (int i=0;i < Matrix.length;i++) {    // collects diagonal sums
            diag1sum += Matrix[i][i];
            diag2sum += Matrix[i][Matrix.length-i];
        }
        if ((diag1sum != magicNumber) || (diag2sum != magicNumber)) {   //checks diagonal sums
            hasMagicPattern = false;
        }

        return hasMagicPattern;
    }

    /*
     * Creates MagicSquare f one integer.
     */
    public MagicSquare(int n) {
        Matrix = new int[n][n];

        int row = n - 1;
        int col = n / 2;
        int oldRow;
        int oldCol;

        for (int i=1; i < n*n + 1; i++) {
            Matrix[row][col] = i;
            oldRow = row;
            oldCol = col;
            row++;
            col++;

            if (row == n) {
                row = 0;
            }
            if (col == n) {
                col = 0;
            }

            if (Matrix[row][col]>0) {
                row = oldRow; 
                col = oldCol;
                row--;
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
        if (containsAllNumbers() && hasMagicPattern()) {
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