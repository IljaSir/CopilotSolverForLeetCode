class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length / 2;
        int[][] dp = new int[1 << (2 * n)][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = 0;
        for (int mask = 0; mask < (1 << (2 * n)); mask++) {
            int bits = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if (dp[mask][i] >= 0) {
                    for (int j = 0; j < 2 * n; j++) {
                        if (((mask >> j) & 1) == 0) {
                            for (int k = j + 1; k < 2 * n; k++) {
                                if (((mask >> k) & 1) == 0) {
                                    int nmask = mask | (1 << j) | (1 << k);
                                    dp[nmask][i + 1] = Math.max(dp[nmask][i + 1], dp[mask][i] + (bits / 2 + 1) * gcd(nums[j], nums[k]));
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[(1 << (2 * n)) - 1][n];
    }
}