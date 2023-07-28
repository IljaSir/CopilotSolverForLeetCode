class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int count = 0;
        int i = 0;
        int j = 0;
        int prod = 1;
        while (j < nums.length) {
            prod = prod * nums[j];
            while (i <= j && prod >= k) {
                prod = prod / nums[i];
                i++;
            }
            count = count + j - i + 1;
            j++;
        }
        return count;
    }
}