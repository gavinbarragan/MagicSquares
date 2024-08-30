


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MagicSquare implements MagicSquareInterface {
    private int[][] matrix;
    private boolean isMagicSquare;
    

    // Constructor to read the matrix from a file
    public MagicSquare(String filename) throws FileNotFoundException {
        this.matrix = readMatrix(filename);
        this.isMagicSquare = checkIfMagicSquare();
    }

    // Constructor to generate a new magic square and write it to a file
    public MagicSquare(String filename, int dimension) throws IOException {
        if (dimension % 2 == 0) {
            System.out.println("invalid input.");
        }
        this.matrix = generateMagicSquare(dimension);
        writeMatrix(this.matrix, filename);
        this.isMagicSquare = true;
    }

    // Private method to read the matrix from a file
    private int[][] readMatrix(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner documentScanner = new Scanner(file);  // Scanner for the entire file
    
        int size = Integer.parseInt(documentScanner.nextLine().trim());  // Read the matrix size from the first line
        int[][] matrix = new int[size][size];
    
        for (int row = 0; row < size; row++) {
            String line = documentScanner.nextLine();  // Read each line of the matrix
            Scanner lineScanner = new Scanner(line);  // Scanner for individual line
    
            for (int col = 0; col < size; col++) {
                if (lineScanner.hasNext()) {
                    matrix[row][col] = Integer.parseInt(lineScanner.next().trim());  // Parse each integer
                }
            }
            lineScanner.close();
        }
    
        documentScanner.close();
        return matrix;
    }
    

    // Private method to generate a magic square
    private int[][] generateMagicSquare(int size) {
        int[][] matrix = new int[size][size];
        int row = size - 1;
        int col = size / 2;
        for (int i = 1; i <= size * size; i++) {
            matrix[row][col] = i;
            int newRow = (row + 1) % size;
            int newCol = (col + 1) % size;
            if (matrix[newRow][newCol] != 0) {
                row = (row - 1 + size) % size;
            } else {
                row = newRow;
                col = newCol;
            }
        }
        return matrix;
    }

    // Private method to write the matrix to a file
    private void writeMatrix(int[][] matrix, String filename) throws IOException {
        PrintWriter outFile = new PrintWriter(new FileWriter(filename));
        outFile.println(matrix.length);
        for (int[] row : matrix) {
            for (int num : row) {
                outFile.print(num + " ");
            }
            outFile.println();
        }
        outFile.close();
    }

    // Method to check if the matrix is a magic square
    @Override
    public boolean isMagicSquare() {
        return isMagicSquare;
    }

    // Method to return a copy of the matrix
    @Override
    public int[][] getMatrix() {
        int[][] copy = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, matrix[i].length);
        }
        return copy;
    }

    // Method to check if the current matrix is a magic square
    private boolean checkIfMagicSquare() {
        int n = matrix.length;
        int magicSum = n * (n*n + 1) / 2;

        // Check rows and columns
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != magicSum || colSum != magicSum) {
                return false;
            }
        }

        // Check diagonals
        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < n; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][n - i - 1];
        }
        
        if (diag1Sum == magicSum && diag2Sum == magicSum) {
            return true;
        }
        else {
            return false;
        }
        
    }

    // Method to return the formatted string representation of the matrix
    @Override

    public String toString() {
        String result = "The matrix\n";
        for (int[] row : matrix) {
            for (int num : row) {
                result += num + " ";
            }
            result += "\n";
        }
        if (isMagicSquare()) {
            result += "is a magic square.";
        } else {
            result += "is not a magic square.";
        }
        return result;
    }
    
    

}
