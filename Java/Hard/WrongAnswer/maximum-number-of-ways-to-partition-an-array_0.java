class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i;
            while (left[i] > 0 && sum[i + 1] - sum[left[i]] >= sum[left[i]]) {
                left[i] = left[left[i] - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = i;
            while (right[i] < n - 1 && sum[n] - sum[right[i] + 1] >= sum[right[i] + 1] - sum[i]) {
                right[i] = right[right[i] + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] == sum[n] - sum[i]) {
                res++;
            }
        }
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            int s = sum[i + 1] - sum[l];
            int t = sum[r + 1] - sum[i + 1];
            if (s - t == k) {
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}