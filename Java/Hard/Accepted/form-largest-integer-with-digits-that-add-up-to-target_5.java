class Solution {
    public String largestNumber(int[] cost, int target) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < 9; ++i) {
            int c = cost[i];
            for (int j = c; j <= target; ++j)
                dp[j] = Math.max(dp[j], dp[j - c] + 1);
        }
        if (dp[target] < 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 8, j = target; i >= 0; --i) {
            int c = cost[i];
            while (j >= c && dp[j] == dp[j - c] + 1) {
                sb.append(i + 1);
                j -= c;
            }
        }
        return sb.toString();
    }
}