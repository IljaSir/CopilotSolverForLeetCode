class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int mod = 1000000007;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int[] type : types) {
            int count = type[0];
            int marks = type[1];
            int[] dp2 = new int[target+1];
            for (int i = 0; i <= target; i++) {
                if (i >= marks) {
                    dp2[i] = (dp2[i] + dp[i-marks]) % mod;
                }
                dp2[i] = (dp2[i] + dp[i]) % mod;
            }
            dp = dp2;
        }
        return dp[target];
    }
}