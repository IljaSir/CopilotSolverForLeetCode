class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; ++i) sum[i + 1] = sum[i] + nums[i];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[3];
        for (int i = k, tot = sum[k] - sum[0]; i < n; ++i) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                left[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else {
                left[i] = left[i - 1];
            }
        }
        right[n - k] = n - k;
        for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; --i) {
            if (sum[i + k] - sum[i] >= tot) {
                right[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        int best = 0;
        for (int i = k; i <= n - 2 * k; ++i) {
            int l = left[i - 1], r = right[i + k];
            int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (tot > best) {
                ans[0] = l; ans[1] = i; ans[2] = r;
                best = tot;
            }
        }
        return ans;
    }
}