class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int n = nums.length;
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (check(nums, threshold, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return check(nums, threshold, l) ? l : -1;
    }
    private boolean check(int[] nums, int threshold, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        if (sum > threshold * k) {
            return true;
        }
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > threshold * k) {
                return true;
            }
        }
        return false;
    }
}