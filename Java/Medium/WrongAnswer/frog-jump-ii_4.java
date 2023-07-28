class Solution {
    public int maxJump(int[] stones) {
        
        int n = stones.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (stones[i] - stones[j] <= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + (stones[i] - stones[j]));
                    if (dp[i] == 0) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}