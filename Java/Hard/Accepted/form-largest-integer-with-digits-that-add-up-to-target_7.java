class Solution {
    public String largestNumber(int[] cost, int target) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int t = 1; t <= target; t++) {
            for (int i = 0; i < 9; i++) {
                if (t >= cost[i]) {
                    dp[t] = Math.max(dp[t], dp[t - cost[i]] + 1);
                }
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 8, t = target; i >= 0; i--) {
            for (int c = cost[i]; t >= c && dp[t] == dp[t - c] + 1; t -= c) {
                sb.append(i + 1);
            }
        }
        return sb.toString();
    }
}