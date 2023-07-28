class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int right = 0;
        int prod = 1;
        while (right < n) {
            prod *= nums[right];
            while (left <= right && prod >= k) {
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}