class Solution {
    public int checkRecord(int n) {
        
        long[][][] dp = new long[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return (int) (cal(n, 0, 0, dp) % 1000000007);
    }
    public long cal(int n, int a, int l, long[][][] dp) {
        if (a > 1 || l > 2) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n][a][l] != -1) {
            return dp[n][a][l];
        }
        long ans = 0;
        ans += cal(n - 1, a, 0, dp);
        ans += cal(n - 1, a + 1, 0, dp);
        ans += cal(n - 1, a, l + 1, dp);
        dp[n][a][l] = ans;
        return ans;
    }
}