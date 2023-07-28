class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            int[] seen = new int[17];
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) {
                    if (++seen[nums[j]] > 1) break;
                    int max = nums[j], min = nums[j];
                    for (int l = 0; l < n; l++) {
                        if (((i >> l) & 1) == 1) {
                            max = Math.max(max, nums[l]);
                            min = Math.min(min, nums[l]);
                        }
                    }
                    dp[i | (1 << j)] = Math.min(dp[i | (1 << j)], dp[i] + max - min);
                }
            }
        }
        return dp[(1 << n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << n) - 1];
    }
}