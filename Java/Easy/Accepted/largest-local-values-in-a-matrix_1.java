class Solution {
    public int[][] largestLocal(int[][] grid) {
        
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = grid[i][j];
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        max = Math.max(max, grid[i + k][j + l]);
                    }
                }
                maxLocal[i - 1][j - 1] = max;
            }
        }
        return maxLocal;
    }
}