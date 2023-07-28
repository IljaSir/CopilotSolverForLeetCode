class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        for (int mask = 0; mask < (1 << n); mask++) {
            int cnt = Integer.bitCount(mask);
            if (cnt > numSlots || cnt > n - numSlots) continue;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i] & (i + 1);
                }
            }
            dp[mask] = sum;
        }
        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                if ((mask & (1 << i)) != 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << i)]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}