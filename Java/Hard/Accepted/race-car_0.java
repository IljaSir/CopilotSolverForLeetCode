class Solution {
    public int racecar(int target) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int t = 1; t <= target; ++t) {
            int k = 32 - Integer.numberOfLeadingZeros(t);
            if (t == (1 << k) - 1) {
                dp[t] = k;
                continue;
            }
            for (int j = 0; j < k - 1; ++j)
                dp[t] = Math.min(dp[t], dp[t - (1 << (k - 1)) + (1 << j)] + k + j + 1);
            if ((1 << k) - 1 - t < t)
                dp[t] = Math.min(dp[t], dp[(1 << k) - 1 - t] + k + 1);
        }
        return dp[target];
    }
}