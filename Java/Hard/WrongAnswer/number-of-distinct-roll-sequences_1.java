class Solution {
    public int distinctSequences(int n) {
        
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][6][6];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (gcd(i, j) == 1) {
                    dp[2][i - 1][j - 1] = 1;
                }
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    for (int l = 1; l <= 6; l++) {
                        if (gcd(j, k) == 1 && gcd(k, l) == 1) {
                            dp[i][k - 1][l - 1] = (dp[i][k - 1][l - 1] + dp[i - 1][j - 1][k - 1]) % mod;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                res = (res + dp[n][i - 1][j - 1]) % mod;
            }
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}