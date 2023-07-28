class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int n = types.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int count = types[i][0];
            int mark = types[i][1];
            int[] newDp = new int[target + 1];
            for (int j = 0; j <= target; j++) {
                newDp[j] = dp[j];
            }
            for (int j = 0; j <= target; j++) {
                for (int k = 1; k <= count && j + k * mark <= target; k++) {
                    newDp[j + k * mark] = (newDp[j + k * mark] + dp[j]) % 1000000007;
                }
            }
            dp = newDp;
        }
        return dp[target];
    }
}