class Solution {
    public int countHillValley(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                count++;
            }
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                count++;
            }
        }
        return count;
    }
}