class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i] = row[i] * 10 + grid[i][j];
                col[j] = col[j] * 10 + grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == col[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}