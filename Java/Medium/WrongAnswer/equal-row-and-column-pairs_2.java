class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == grid[j][i]) {
                    count++;
                }
            }
        }
        return count;
    }
}