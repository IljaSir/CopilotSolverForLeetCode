class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n][6];
        int[][] count = new int[n][6];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < 6; i++) {
            count[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j == k) {
                        if (count[i - 1][j] < rollMax[j]) {
                            dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                            count[i][j] = count[i - 1][j] + 1;
                        }
                    }
                    else {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                        count[i][j] = 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            ans = (ans + dp[n - 1][i]) % mod;
        }
        return ans;
    }
}