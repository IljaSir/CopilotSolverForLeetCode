class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i;
            right[i] = i;
        }
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && nums[p] >= nums[i]) {
                p = left[p] - 1;
            }
            left[i] = p + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && nums[p] >= nums[i]) {
                p = right[p] + 1;
            }
            right[i] = p - 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (k >= left[i] && k <= right[i]) {
                res = Math.max(res, nums[i] * (right[i] - left[i] + 1));
            }
        }
        return res;
    }
}