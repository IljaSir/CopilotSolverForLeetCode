class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int n = prizePositions.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && prizePositions[j] - prizePositions[i] <= k) {
                j++;
            }
            dp[i] = j - i;
            res = Math.max(res, dp[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i + dp[i] < n) {
                dp[i] += dp[i + dp[i]];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}