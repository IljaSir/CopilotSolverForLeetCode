class Solution {
    public int minCost(int n, int[] cuts) {
        
        int m = cuts.length;
        int[] cut = new int[m + 2];
        cut[0] = 0;
        cut[m + 1] = n;
        for (int i = 0; i < m; i++) {
            cut[i + 1] = cuts[i];
        }
        Arrays.sort(cut);
        int[][] dp = new int[m + 2][m + 2];
        for (int i = m; i >= 0; i--) {
            for (int j = i + 1; j <= m + 1; j++) {
                if (j - i <= 2) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                    dp[i][j] += cut[j] - cut[i];
                }
            }
        }
        return dp[0][m + 1];
    }
}