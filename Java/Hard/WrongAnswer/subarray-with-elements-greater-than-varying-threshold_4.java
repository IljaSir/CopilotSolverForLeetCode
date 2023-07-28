class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int left = 1, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(nums, mid, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return check(nums, left, threshold) ? left : -1;
    }
    public boolean check(int[] nums, int k, int threshold) {
        double sum = 0;
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