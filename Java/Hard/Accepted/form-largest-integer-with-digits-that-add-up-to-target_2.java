class Solution {
    public String largestNumber(int[] cost, int target) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = cost[i]; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + 1);
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 8, j = target; i >= 0; i--) {
            while (j >= cost[i] && dp[j] == dp[j - cost[i]] + 1) {
                sb.append(i + 1);
                j -= cost[i];
            }
        }
        return sb.toString();
    }
}