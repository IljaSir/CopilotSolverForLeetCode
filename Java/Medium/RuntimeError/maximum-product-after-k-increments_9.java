class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int maxProduct = 1;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (count < k) {
            if (i < j && nums[i] < nums[j]) {
                maxProduct *= nums[j];
                j--;
            } else {
                maxProduct *= nums[i];
                i++;
            }
            count++;
        }
        return maxProduct;
    }
}