class Solution {
    public String stoneGameIII(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += stoneValue[i];
            dp[i] = sum - dp[i];
            if (i + 1 < n) dp[i] = Math.max(dp[i], sum - stoneValue[i] - dp[i + 1]);
            if (i + 2 < n) dp[i] = Math.max(dp[i], sum - stoneValue[i] - stoneValue[i + 1] - dp[i + 2]);
        }
        return dp[0] == sum - dp[0] ? "Tie" : dp[0] > sum - dp[0] ? "Alice" : "Bob";
    }
}