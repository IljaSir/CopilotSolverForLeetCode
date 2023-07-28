class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + cardPoints[i - 1];
        }
        int ans = dp[k];
        for (int i = 1; i <= k; i++) {
            ans = Math.max(ans, dp[n] - dp[n - i] + dp[i - 1]);
        }
        return ans;
    }
}