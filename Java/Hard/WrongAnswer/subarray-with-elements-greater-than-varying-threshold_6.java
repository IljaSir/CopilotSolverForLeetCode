class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int l = 1;
        int r = nums.length;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValid(nums, threshold, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
    
    private boolean isValid(int[] nums, int threshold, int k) {
        int sum = 0;
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