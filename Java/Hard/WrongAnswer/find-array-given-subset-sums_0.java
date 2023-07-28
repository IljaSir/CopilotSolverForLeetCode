class Solution {
    public int[] recoverArray(int n, int[] sums) {
        
        int m = sums.length;
        Arrays.sort(sums);
        int[][] dp = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = sums[0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = sums[i];
            for (int j = 0; j < (1 << n); j++) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], sums[i] - dp[i - 1][j - 1]);
                }
            }
        }
        int[] ans = new int[n];
        int j = (1 << n) - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (j > 0 && dp[i][j] != dp[i][j - 1]) {
                ans[Integer.bitCount(j - 1)] = sums[i];
                j--;
            }
        }
        return ans;
    }
}