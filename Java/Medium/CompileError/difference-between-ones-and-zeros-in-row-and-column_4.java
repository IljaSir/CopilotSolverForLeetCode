class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        
        int[][] diff = new int[grid.length][grid[0].length];
        int[] onesRow = new int[grid.length];
        int[] onesCol = new int[grid[0].length];
        int[] zerosRow = new int[grid.length];
        int[] zerosCol = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
             else {
                    zerosRow[i]++;
                    zerosCol[j]++;
                
    }
}