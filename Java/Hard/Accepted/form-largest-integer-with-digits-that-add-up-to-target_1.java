class Solution {
    public String largestNumber(int[] cost, int target) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < 9; j++) {
                if (i >= cost[j]) {
                    dp[i] = Math.max(dp[i], dp[i - cost[j]] + 1);
                }
            }
        }
        if (dp[target] < 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 8; i >= 0; i--) {
            while (target >= cost[i] && dp[target] == dp[target - cost[i]] + 1) {
                sb.append(i + 1);
                target -= cost[i];
            }
        }
        return sb.toString();
    }
}