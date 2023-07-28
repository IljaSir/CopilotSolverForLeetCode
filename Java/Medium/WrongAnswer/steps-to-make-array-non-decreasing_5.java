class Solution {
    public int totalSteps(int[] nums) {
        
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                nums[i + 1] = nums[i];
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
}