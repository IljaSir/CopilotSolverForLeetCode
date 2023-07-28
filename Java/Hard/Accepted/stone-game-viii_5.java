class Solution {
    public int stoneGameVIII(int[] stones) {
        
        int n = stones.length;
        int[] sums = new int[n];
        sums[0] = stones[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i-1] + stones[i];
        }
        int[] dp = new int[n];
        dp[n-1] = sums[n-1];
        for (int i = n-2; i > 0; i--) {
            dp[i] = Math.max(dp[i+1], sums[i]-dp[i+1]);
        }
        return dp[1];
    }
}