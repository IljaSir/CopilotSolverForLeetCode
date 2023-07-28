class Solution {
    public int findClosestNumber(int[] nums) {
        
        int closest = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < min) {
                min = Math.abs(nums[i]);
                closest = nums[i];
            } else if (Math.abs(nums[i]) == min) {
                if (nums[i] > closest) {
                    closest = nums[i];
                }
            }
        }
        return closest;
    }
}