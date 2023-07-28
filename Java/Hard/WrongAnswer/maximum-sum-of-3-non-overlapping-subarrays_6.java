class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] left = new int[nums.length];
        int best = 0;
        for (int i = k, max = sum[k] - sum[0]; i < nums.length; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > max) {
                max = sum[i + 1] - sum[i + 1 - k];
                best = i + 1 - k;
            }
            left[i] = best;
        }
        int[] right = new int[nums.length];
        best = nums.length - k;
        for (int i = nums.length - k - 1, max = sum[nums.length] - sum[nums.length - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= max) {
                max = sum[i + k] - sum[i];
                best = i;
            }
            right[i] = best;
        }
        int[] ans = new int[] {-1, -1, -1};
        for (int i = k; i <= nums.length - 2 * k; i++) {
            int l = left[i - 1], r = right[i + k];
            int total = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (ans[0] == -1 || total > (sum[ans[0] + k] - sum[ans[0]]) + (sum[ans[1] + k] - sum[ans[1]]) + (sum[ans[2] + k] - sum[ans[2]])) {
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
}