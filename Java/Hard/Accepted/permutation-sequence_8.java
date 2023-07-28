class Solution {
    public String getPermutation(int n, int k) {
        
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return getPermutation(nums, k);
    }

    private String getPermutation(int[] nums, int k) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        int factorial = factorial(nums.length - 1);
        int index = (k - 1) / factorial;
        int[] nextNums = new int[nums.length - 1];
        for (int i = 0; i < nextNums.length; i++) {
            if (i < index) {
                nextNums[i] = nums[i];
            } else {
                nextNums[i] = nums[i + 1];
            }
        }
        return String.valueOf(nums[index]) + getPermutation(nextNums, k - index * factorial);
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}