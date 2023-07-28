class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int left = 1;
        int right = nums.length;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (validSubarraySize(nums, threshold, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    private boolean validSubarraySize(int[] nums, int threshold, int size) {
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        if (sum > threshold * size) {
            return true;
        }
        for (int i = size; i < nums.length; i++) {
            sum += nums[i] - nums[i - size];
            if (sum > threshold * size) {
                return true;
            }
        }
        return false;
    }
}