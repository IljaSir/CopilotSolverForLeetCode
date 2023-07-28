class Solution {
    public int distinctSequences(int n) {
        
        int MOD = 1000000007;
        int[][][] dp = new int[n][7][7];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 1;
                    } else {
                        for (int x = 1; x <= 6; x++) {
                            if (gcd(x, j) == 1 && gcd(x, k) == 1) {
                                dp[i][j][k] = (dp[i][j][k] + dp[i - 1][x][j]) % MOD;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                res = (res + dp[n - 1][i][j]) % MOD;
            }
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}