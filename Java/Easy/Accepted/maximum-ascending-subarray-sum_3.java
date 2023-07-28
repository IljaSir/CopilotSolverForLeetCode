class Solution {
    public int maxAscendingSum(int[] nums) {
        
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        return Math.max(max, sum);
    }
}