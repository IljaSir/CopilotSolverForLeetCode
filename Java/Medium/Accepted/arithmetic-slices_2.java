class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int count = 0;
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
            } else {
                sum += count * (count + 1) / 2;
                count = 0;
            }
        }
        sum += count * (count + 1) / 2;
        return sum;
    }
}