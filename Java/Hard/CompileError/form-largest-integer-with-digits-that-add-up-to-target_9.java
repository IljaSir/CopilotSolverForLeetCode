class Solution {
    public String largestNumber(int[] cost, int target) {
        
        int n = cost.length;
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 1; i <= target; i++) {
            dp[i] = "0";
            for (int j = 0; j < n; j++) {
                if (i - cost[j] >= 0 && !dp[i - cost[j]].equals("0")) {
                    dp[i] = max(dp[i], (j + 1) + dp[i - cost[j]]);
                }
            }
        }
        return dp[target];
    }
}