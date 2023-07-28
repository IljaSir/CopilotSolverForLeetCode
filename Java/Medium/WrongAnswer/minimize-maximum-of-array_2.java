class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int result = max;
        while (result < sum) {
            result++;
            sum -= nums.length - 1;
        }
        return result;
    }
}