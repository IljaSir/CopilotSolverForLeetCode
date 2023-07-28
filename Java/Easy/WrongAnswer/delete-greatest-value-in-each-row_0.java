class Solution {
    public int deleteGreatestValue(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        while (m > 0) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                int maxIndex = 0;
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > grid[i][maxIndex]) {
                        maxIndex = j;
                    }
                }
                max += grid[i][maxIndex];
                grid[i][maxIndex] = grid[i][m - 1];
            }
            ans += max;
            m--;
        }
        return ans;
    }
}