class Solution {
    public int racecar(int target) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= target; ++i) {
            int k = 1, pos = 1;
            while (pos < i) {
                for (int j = 0, q = 0; j < k; ++j, q = 0) {
                    for (; q <= k - j; ++q) {
                        dp[i] = Math.min(dp[i], k + 1 + j + 1 + q + dp[i - (pos - (1 << j) + (1 << q))]);
                    }
                }
                k++;
                pos = (1 << k) - 1;
            }
            dp[i] = Math.min(dp[i], k + (pos == i ? 0 : 1 + dp[pos - i]));
        }
        return dp[target];
    }
}