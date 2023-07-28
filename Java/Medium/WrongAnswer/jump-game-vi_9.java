class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        int[] q = new int[n];
        int l = 0;
        int r = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = max + nums[i];
            while (l < r && dp[q[r - 1]] < dp[i]) {
                r--;
            }
            q[r++] = i;
            if (q[l] < i - k + 1) {
                l++;
            }
            max = dp[q[l]];
        }
        return dp[n - 1];
    }
}