class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int mod = 1000000007;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < types.length; i++) {
            int count = types[i][0];
            int points = types[i][1];
            for (int j = 0; j < points; j++) {
                int[] dp2 = new int[target+1];
                for (int k = j; k <= target; k += points) {
                    dp2[k] = dp[k];
                    if (k >= count*points) {
                        dp2[k] += dp2[k-count*points];
                        dp2[k] %= mod;
                    }
                }
                dp = dp2;
            }
        }
        return dp[target];
    }
}