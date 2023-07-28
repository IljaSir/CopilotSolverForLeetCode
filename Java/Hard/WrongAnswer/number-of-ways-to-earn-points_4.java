class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int n = types.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int count = types[i][0];
            int marks = types[i][1];
            for (int j = 1; j <= count; j++) {
                for (int k = target; k >= marks; k--) {
                    dp[k] = (dp[k] + dp[k - marks]) % 1000000007;
                }
            }
        }
        return dp[target];
    }
}