class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int l = 1, r = nums.length;
        while (l <= r) {
            int m = (l + r) / 2;
            if (valid(nums, m, threshold)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
    
    private boolean valid(int[] nums, int k, int threshold) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        if (sum > (long) threshold * k) {
            return true;
        }
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > (long) threshold * k) {
                return true;
            }
        }
        return false;
    }
}