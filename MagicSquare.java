public class MagicSquare {

    private int[][] magicGrid;


    public MagicSquare(int n) {
        int magicNumber = n * (n*n + 1) / 2;  
        
        magicGrid = new int[n][n];
        for (int r = 0;r < n;r++) {           //loop goes to each individual location in the grid 
            for (int c=0;c<n; c++) {
            }
        }     
    }
}