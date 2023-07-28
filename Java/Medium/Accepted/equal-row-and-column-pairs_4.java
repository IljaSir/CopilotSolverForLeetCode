class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;
        int[][] row = new int[n][n];
        int[][] col = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j] = grid[i][j];
                col[j][i] = grid[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(row[i], col[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}