class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[1 << n][n / 2 + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < dp.length; i++) {
            int c = Integer.bitCount(i);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    for (int k = 0; k < n; k++) {
                        if (j != k && (i & (1 << k)) != 0) {
                            int s = c / 2;
                            dp[i][s] = Math.max(dp[i][s], dp[i ^ (1 << j) ^ (1 << k)][s - 1] + c * gcd(nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1][n / 2];
    }
}