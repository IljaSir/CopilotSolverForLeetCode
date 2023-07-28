class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        if (original.length != m * n) return new int[0][0];
        int[][] result = new int[m][n];
        int row = 0;
        int col = 0;
        for (int i = 0; i < original.length; i++) {
            result[row][col] = original[i];
            col++;
            if (col == n) {
                col = 0;
                row++;
            }
        }
        return result;
    }
}