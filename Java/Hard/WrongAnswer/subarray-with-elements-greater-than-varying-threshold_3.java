class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int n = nums.length;
        int left = 1;
        int right = n;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, threshold, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    private boolean isValid(int[] nums, int threshold, int size) {
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        if (sum > threshold * size) {
            return true;
        }
        for (int i = size; i < nums.length; i++) {
            sum = sum - nums[i - size] + nums[i];
            if (sum > threshold * size) {
                return true;
            }
        }
        return false;
    }
}