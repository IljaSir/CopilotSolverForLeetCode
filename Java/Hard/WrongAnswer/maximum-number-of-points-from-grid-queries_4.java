class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = grid[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int max = 0;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    int x = j;
                    int y = k;
                    while (x <= m && y <= n && preSum[x][y] - preSum[x - j][y] - preSum[x][y - k] + preSum[x - j][y - k] <= queries[i]) {
                        max = Math.max(max, (x - j + 1) * (y - k + 1));
                        x++;
                        y++;
                    }
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}