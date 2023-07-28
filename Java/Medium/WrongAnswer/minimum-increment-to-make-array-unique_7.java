class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
        int pre = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= pre) {
                result += pre - nums[i] + 1;
                pre++;
            } else {
                pre = nums[i];
            }
        }
        return result;
    }
}