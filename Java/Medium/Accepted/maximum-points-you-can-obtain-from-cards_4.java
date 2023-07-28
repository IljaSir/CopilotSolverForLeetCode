class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + cardPoints[i - 1];
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, dp[i] + dp[n] - dp[n - k + i]);
        }
        return ans;
    }
}