class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        
        int n = (int)Math.floor(Math.log(target)/Math.log(x)) + 1;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int curr = (int) Math.pow(x, i);
            dp[i] = i == n - 1 ? 0 : Math.min(dp[i + 1] + 1, dp[i + 1] + 1 + i + 1);
            if (target > curr) {
                int k = (target / curr);
                int next = target - k * curr;
                int cost = k * i - 1;
                if (next > 0) {
                    cost += Math.min(dp[i], leastOpsExpressTarget(x, next) + i);
                }
                dp[i] = Math.min(dp[i], cost);
            }
        }
        return dp[0];
    }
}