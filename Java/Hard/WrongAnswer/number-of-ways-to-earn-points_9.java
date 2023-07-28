class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int mod = 1000000007;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int[] type : types) {
            int[] dp2 = new int[target + 1];
            for (int i = 0; i <= target; i++) {
                for (int j = 1; j <= type[0] && i + j * type[1] <= target; j++) {
                    dp2[i + j * type[1]] = (dp2[i + j * type[1]] + dp[i]) % mod;
                }
            }
            dp = dp2;
        }
        return dp[target];
    }
}