class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1<<n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 0; mask < (1<<n); mask++) {
            if (dp[mask] == -1) continue;
            int[] cnt = new int[17];
            int max = 0, min = 17;
            for (int i = 0; i < n; i++) {
                if ((mask & (1<<i)) != 0) {
                    cnt[nums[i]]++;
                    max = Math.max(max, nums[i]);
                    min = Math.min(min, nums[i]);
                }
            }
            if (max == min) continue;
            if (max - min > 1) {
                for (int i = 0; i < n; i++) {
                    if ((mask & (1<<i)) == 0) {
                        dp[mask | (1<<i)] = -1;
                    }
                }
                continue;
            }
            int rem = n - Integer.bitCount(mask);
            int size = rem / k;
            for (int i = 0; i < n; i++) {
                if ((mask & (1<<i)) == 0) {
                    if (cnt[nums[i]] < size) {
                        dp[mask | (1<<i)] = dp[mask] + max - min;
                    }
                }
            }
        }
        return dp[(1<<n) - 1];
    }
}