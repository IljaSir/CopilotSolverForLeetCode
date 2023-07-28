class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[k] = k;
        right[k] = k;
        for (int i = k - 1; i >= 0; i--) {
            left[i] = nums[i] > nums[i + 1] ? i : left[i + 1];
        }
        for (int i = k + 1; i < n; i++) {
            right[i] = nums[i] > nums[i - 1] ? i : right[i - 1];
        }
        int res = nums[k];
        for (int i = k, j = k; i >= 0 || j < n; ) {
            if (i < 0 || j < n && nums[i] < nums[j]) {
                j++;
                res = Math.max(res, (right[j] - left[j] + 1) * nums[j]);
            } else {
                i--;
                res = Math.max(res, (right[i] - left[i] + 1) * nums[i]);
            }
        }
        return res;
    }
}