class Solution {
    public int getMaxLen(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] neg = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                dp[i] = i > 0 ? dp[i - 1] + 1 : 1;
                neg[i] = i > 0 ? (neg[i - 1] > 0 ? neg[i - 1] + 1 : 0) : 0;
            } else if (nums[i] < 0) {
                dp[i] = i > 0 ? (neg[i - 1] > 0 ? neg[i - 1] + 1 : 0) : 0;
                neg[i] = i > 0 ? dp[i - 1] + 1 : 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}