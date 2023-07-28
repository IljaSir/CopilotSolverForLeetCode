class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int m = n - 2 * numSlots;
        int[] dp = new int[1 << numSlots];
        for (int i = 0; i < n; i++) {
            int[] next = new int[1 << numSlots];
            for (int j = 0; j < (1 << numSlots); j++) {
                int idx = Integer.bitCount(j);
                if (i - idx >= m) {
                    next[j] = Math.max(next[j], dp[j] + (nums[i] & idx));
                }
                if (idx > 0) {
                    next[j] = Math.max(next[j], dp[j ^ (1 << (idx - 1))] + (nums[i] & idx));
                }
            }
            dp = next;
        }
        int ans = 0;
        for (int i = 0; i < (1 << numSlots); i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}