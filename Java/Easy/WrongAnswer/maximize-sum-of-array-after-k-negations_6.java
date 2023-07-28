class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        if (k == 0) {
            return sum;
        }
        if (k % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min;
        }
    }
}