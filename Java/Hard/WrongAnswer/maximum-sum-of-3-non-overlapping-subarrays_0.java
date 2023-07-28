class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] dp = new int[n - k + 1];
        int max = 0;
        for (int i = 0; i <= n - k; i++) {
            dp[i] = sum[i + k] - sum[i];
            if (dp[i] > dp[max]) {
                max = i;
            }
        }
        int[] left = new int[n - k + 1];
        left[k - 1] = max;
        for (int i = k; i <= n - k; i++) {
            if (dp[i] >= dp[left[i - 1]]) {
                left[i] = i;
            } else {
                left[i] = left[i - 1];
            }
        }
        int[] right = new int[n - k + 1];
        right[n - k] = max;
        for (int i = n - k - 1; i >= 0; i--) {
            if (dp[i] >= dp[right[i + 1]]) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        int[] res = new int[3];
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            if (res[0] == 0 || sum[res[0] + k] - sum[res[0]] + sum[res[1] + k] - sum[res[1]] + sum[res[2] + k] - sum[res[2]] < sum[l + k] - sum[l] + sum[i + k] - sum[i] + sum[r + k] - sum[r]) {
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}