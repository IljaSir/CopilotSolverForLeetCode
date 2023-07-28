class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        // dp[i][j][k] means the number of sequences of length i, ends with j and the last j appears for k times
        // dp[i][j][k] = sum(dp[i-1][j][l]) for all l < k
        // dp[i][j][k] = sum(dp[i-1][l][m]) for all l != j
        // dp[i][j][k] = sum(dp[i-1][l][m]) for all l != j and m < rollMax[l]
        int[][][] dp = new int[n+1][6][16];
        for (int i = 0; i < 6; i++) {
            dp[1][i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int l = 0; l < 6; l++) {
                        for (int m = 1; m <= rollMax[l]; m++) {
                            if (l == j && m == k) continue;
                            if (l == j && m < k) continue;
                            dp[i][j][k] = (dp[i][j][k] + dp[i-1][l][m]) % 1000000007;
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= rollMax[i]; j++) {
                result = (result + dp[n][i][j]) % 1000000007;
            }
        }
        return result;
    }
}