class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] dp = new int[n - k + 1];
        int[] left = new int[n - k + 1];
        int max = 0;
        for (int i = k; i <= n; i++) {
            int cur = sum[i] - sum[i - k];
            if (cur > max) {
                max = cur;
                left[i - k] = i - k;
            } else {
                left[i - k] = left[i - k - 1];
            }
            dp[i - k] = max;
        }
        int[] right = new int[n - k + 1];
        max = 0;
        for (int i = n - k; i >= 0; i--) {
            int cur = sum[i + k] - sum[i];
            if (cur >= max) {
                max = cur;
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        int[] res = new int[3];
        max = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - k];
            int r = right[i + k];
            int cur = dp[l] + dp[i] + dp[r];
            if (cur > max) {
                max = cur;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}