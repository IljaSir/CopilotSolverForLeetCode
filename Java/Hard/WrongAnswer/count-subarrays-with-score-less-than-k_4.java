class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long count = 0;
        long product = 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += i - left + 1;
        }
        return count;
    }
}