class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] dp = new int[n - k + 1];
        dp[0] = sum[k] - sum[0];
        int max = dp[0];
        for (int i = 1; i <= n - k; i++) {
            dp[i] = sum[i + k] - sum[i];
            if (dp[i] > max) {
                max = dp[i];
            }
            dp[i] = max;
        }
        int[] pos = new int[n - k + 1];
        pos[n - k] = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            if (dp[i] > dp[pos[i + 1]]) {
                pos[i] = i;
            } else {
                pos[i] = pos[i + 1];
            }
        }
        int[] left = new int[n - 2 * k + 1];
        left[0] = sum[k] - sum[0];
        max = left[0];
        for (int i = 1; i <= n - 2 * k; i++) {
            left[i] = sum[i + k] - sum[i];
            if (left[i] > max) {
                max = left[i];
            }
            left[i] = max;
        }
        int[] res = new int[3];
        int maxSum = 0;
        for (int i = 0; i <= n - 3 * k; i++) {
            int cur = left[i] + dp[pos[i + k]] + sum[i + 2 * k] - sum[i + k];
            if (cur > maxSum) {
                maxSum = cur;
                res[0] = i;
                res[1] = pos[i + k];
                res[2] = i + 2 * k;
            }
        }
        return res;
    }
}