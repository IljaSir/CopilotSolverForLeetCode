class Solution {
    public int maximizeGreatness(int[] nums) {
        
        int max = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                count++;
            }
        }
        return count;
    }
}