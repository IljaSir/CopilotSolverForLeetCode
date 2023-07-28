class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        return atMost(nums, maxK) - atMost(nums, minK - 1);
    }
    
    private long atMost(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;
        long res = 0;
        while (j < n) {
            k -= nums[j++];
            while (k < 0) k += nums[i++];
            res += j - i;
        }
        return res;
    }
}