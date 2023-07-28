class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int[][] dp = new int[m][n];
        int[][] next = new int[m][n];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int mod = 1000000007;
        dp[startRow][startColumn] = 1;
        int ans = 0;
        for (int i = 0; i < maxMove; i++) {
            for (int[] row : next) {
                Arrays.fill(row, 0);
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int[] dir : dirs) {
                        int x = j + dir[0];
                        int y = k + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            ans = (ans + dp[j][k]) % mod;
                        } else {
                            next[x][y] = (next[x][y] + dp[j][k]) % mod;
                        }
                    }
                }
            }
            int[][] temp = dp;
            dp = next;
            next = temp;
        }
        return ans;
    }
}