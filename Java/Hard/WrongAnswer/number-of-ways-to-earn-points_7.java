class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int n = types.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int[] type = types[i];
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= type[0]; k++) {
                    int newTarget = j - k * type[1];
                    if (newTarget < 0) {
                        break;
                    }
                    dp[j] = (dp[j] + dp[newTarget]) % 1000000007;
                }
            }
        }
        return dp[target];
    }
}