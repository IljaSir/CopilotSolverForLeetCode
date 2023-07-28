class Solution {
    public int minDeletion(int[] nums) {
        
        int count = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
            }
            prev = nums[i];
        }
        return count;
    }
}