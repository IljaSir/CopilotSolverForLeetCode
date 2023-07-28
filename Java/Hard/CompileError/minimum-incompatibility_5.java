class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int m = n / k;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE) {
                continue;
            }
            int[] count = new int[17];
            int[] min = new int[17];
            int[] max = new int[17];
            Arrays.fill(min, Integer.MAX_VALUE);
            Arrays.fill(max, -1);
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    count[nums[i]]++;
                    min[nums[i]] = Math.min(min[nums[i]], nums[i]);
                    max[nums[i]] = Math.max(max[nums[i]], nums[i]);
                }
            }
            for (int i = 1; i <= n; i++) { 1];
    }
}