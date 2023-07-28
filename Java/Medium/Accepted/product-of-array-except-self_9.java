class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            left[i] = product;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            right[i] = product;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = right[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = left[i - 1];
            } else {
                result[i] = left[i - 1] * right[i + 1];
            }
        }
        return result;
    }
}