class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int i = 0, j = 0, product = 1, count = 0;
        while (j < nums.length) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}