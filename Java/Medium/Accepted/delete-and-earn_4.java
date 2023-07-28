class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] count = new int[10001];
        for (int x: nums) count[x]++;
        int[] dp = new int[10001];
        dp[1] = count[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i - 2] + i * count[i], dp[i - 1]);
        }
        return dp[10000];
    }
}