class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        if (k % 2 == 1) {
            sum -= 2 * min;
        }
        return sum;
    }
}