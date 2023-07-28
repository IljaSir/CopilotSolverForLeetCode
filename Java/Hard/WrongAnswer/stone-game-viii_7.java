class Solution {
    public int stoneGameVIII(int[] stones) {
        
        int n = stones.length;
        int[] dp = new int[n];
        dp[n-1] = stones[n-1];
        for (int i = n-2; i >= 0; i--) {
            dp[i] = dp[i+1] + stones[i];
        }
        int max = dp[0];
        for (int i = 1; i < n-1; i++) {
            max = Math.max(max, dp[i] - max);
        }
        return max;
    }
}