class Solution {
    public String largestNumber(int[] cost, int target) {
        
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < 9; j++) {
                if (i - cost[j] >= 0 && dp[i - cost[j]] != null) {
                    String s = dp[i - cost[j]] + (char)('1' + j);
                    if (dp[i] == null || s.compareTo(dp[i]) > 0) {
                        dp[i] = s;
                    }
                }
            }
        }
        return dp[target] == null ? "0" : dp[target];
    }
}