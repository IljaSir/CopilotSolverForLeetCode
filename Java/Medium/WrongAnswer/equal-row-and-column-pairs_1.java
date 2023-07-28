class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (grid[i][j] == grid[i][k]) {
                        count++;
                    }
                }
                for (int k = i+1; k < n; k++) {
                    if (grid[i][j] == grid[k][j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}