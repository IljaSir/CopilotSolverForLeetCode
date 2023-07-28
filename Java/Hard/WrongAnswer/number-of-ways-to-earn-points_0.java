class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int[] type : types) {
            int count = type[0], mark = type[1];
            for (int i = mark; i <= target; i++) {
                dp[i] = (dp[i] + dp[i - mark] * count) % 1000000007;
            }
        }
        return dp[target];
    }
}