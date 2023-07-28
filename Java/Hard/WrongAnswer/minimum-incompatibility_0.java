class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == -1) {
                continue;
            }
            int[] cnt = new int[17];
            int max = 0, min = 17, unique = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    continue;
                }
                if (cnt[nums[i]] == 0) {
                    unique++;
                }
                cnt[nums[i]]++;
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
                int next = mask | (1 << i);
                if (unique == n / k) {
                    dp[next] = dp[next] == -1 ? dp[mask] + max - min : Math.min(dp[next], dp[mask] + max - min);
                } else {
                    dp[next] = dp[next] == -1 ? dp[mask] : Math.min(dp[next], dp[mask]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}