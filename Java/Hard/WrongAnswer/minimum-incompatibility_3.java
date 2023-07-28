class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int m = n / k;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < 1 << n; i++) {
            int[] cnt = new int[17];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    cnt[nums[j]]++;
                    if (cnt[nums[j]] > 1) {
                        valid = false;
                        break;
                    }
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                }
            }
            if (!valid) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    dp[i] = Math.min(dp[i], dp[i - (1 << j)] + max - min);
                }
            }
        }
        return dp[(1 << n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << n) - 1];
    }
}