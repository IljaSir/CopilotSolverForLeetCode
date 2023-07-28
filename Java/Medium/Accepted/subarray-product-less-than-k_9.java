class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int n = nums.length;
        int ans = 0, product = 1;
        int left = 0, right = 0;
        while (right < n) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}