class Solution {
    public int minStartValue(int[] nums) {
        
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        return Math.max(1, 1 - min);
    }
}