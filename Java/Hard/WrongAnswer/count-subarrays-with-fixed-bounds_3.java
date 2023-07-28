class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        return countSubarrays(nums, maxK) - countSubarrays(nums, minK - 1);
    }
    
    private long countSubarrays(int[] nums, int bound) {
        int count = 0;
        long res = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] <= bound) {
                count++;
            } else {
                count = 0;
            }
            res += count;
            right++;
        }
        return res;
    }
}