class Solution {
    public int countHillValley(int[] nums) {
        
        int hills = 0, valleys = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                hills++;
            } else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                valleys++;
            }
        }
        return hills + valleys;
    }
}