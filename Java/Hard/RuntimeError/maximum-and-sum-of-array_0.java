class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int[] dp = new int[1 << numSlots];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int mask = (1 << numSlots) - 1; mask >= 0; mask--) {
                if (dp[mask] == -1) continue;
                dp[mask | (1 << i)] = Math.max(dp[mask | (1 << i)], dp[mask] + (nums[i] & mask));
            }
        }
        return dp[(1 << numSlots) - 1];
    }
}