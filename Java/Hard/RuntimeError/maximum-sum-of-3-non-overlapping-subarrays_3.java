class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] left = new int[nums.length], right = new int[nums.length];
        for (int i = 0, max = 0; i < nums.length; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > max) {
                left[i] = i + 1 - k;
                max = sum[i + 1] - sum[i + 1 - k];
            } else {
                left[i] = left[i - 1];
            }
        }
        for (int i = nums.length - 1, max = 0; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= max) {
                right[i] = i;
                max = sum[i + k] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        int[] res = new int[] {-1, -1, -1};
        for (int i = k; i <= nums.length - 2 * k; i++) {
            int l = left[i - 1], r = right[i + k];
            int total = sum[l + k] - sum[l] + sum[r + k] - sum[r] + sum[i + k] - sum[i];
            if (res[0] == -1 || total > sum[res[0] + k] - sum[res[0]] + sum[res[1] + k] - sum[res[1]] + sum[res[2] + k] - sum[res[2]]) {
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}