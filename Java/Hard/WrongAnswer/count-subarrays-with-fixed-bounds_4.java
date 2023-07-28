class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        return countSubarrays(nums, maxK) - countSubarrays(nums, minK - 1);
    }
    
    private long countSubarrays(int[] nums, int bound) {
        long result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= bound) {
                count++;
            } else {
                count = 0;
            }
            result += count;
        }
        return result;
    }
}