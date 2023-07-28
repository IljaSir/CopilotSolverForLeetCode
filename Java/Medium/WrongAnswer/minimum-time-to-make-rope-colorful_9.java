class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[] dp = new int[n];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = neededTime[i];
            if (i > 0 && colors.charAt(i) == colors.charAt(i - 1)) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            max = Math.max(max, dp[i]);
            sum += neededTime[i];
        }
        return sum - max;
    }
}