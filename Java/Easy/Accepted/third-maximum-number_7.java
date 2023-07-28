class Solution {
    public int thirdMax(int[] nums) {
        
        long[] max = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = nums[i];
            } else if (nums[i] > max[1] && nums[i] < max[0]) {
                max[2] = max[1];
                max[1] = nums[i];
            } else if (nums[i] > max[2] && nums[i] < max[1]) {
                max[2] = nums[i];
            }
        }
        if (max[2] == Long.MIN_VALUE) {
            return (int) max[0];
        }
        return (int) max[2];
    }
}