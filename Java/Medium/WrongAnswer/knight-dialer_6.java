class Solution {
    public int knightDialer(int n) {
        
        int[][] dirs = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        int mod = 1000000007;
        int[][] dp = new int[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int[] dir : dirs) {
                    int x = j / 3 + dir[0];
                    int y = j % 3 + dir[1];
                    if (x >= 0 && x < 3 && y >= 0 && y < 3 && (x != 3 || y != 1)) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][x * 3 + y]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[n - 1][i]) % mod;
        }
        return ans;
    }
}