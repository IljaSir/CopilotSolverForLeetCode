class Solution {
    public int minimizeSum(int[] nums) {
        
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        int[] dp = new int[len];
        int[] dp2 = new int[len];
        int[] dp3 = new int[len];
        int[] dp4 = new int[len];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            max[i] = Math.max(max[i - 1], nums[i]);
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        dp[0] = nums[0];
        dp2[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            dp[i] = Math.max(dp[i - 1], nums[i] - min[i - 1]);
            dp2[i] = Math.max(dp2[i - 1], max[i - 1] - nums[i]);
        }
        dp3[len - 1] = nums[len - 1];
        dp4[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            dp3[i] = Math.max(dp3[i + 1], nums[i] - min[i]);
            dp4[i] = Math.max(dp4[i + 1], max[i] - nums[i]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; ++i) {
            res = Math.min(res, dp[i] + dp4[i + 1]);
            res = Math.min(res, dp2[i] + dp3[i + 1]);
        }
        return res;
    }
}