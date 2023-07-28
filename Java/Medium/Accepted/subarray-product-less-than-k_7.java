class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int n = nums.length;
        int left = 0, right = 0;
        int res = 0;
        int product = 1;
        while (right < n) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}