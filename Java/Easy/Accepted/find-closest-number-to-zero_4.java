class Solution {
    public int findClosestNumber(int[] nums) {
        
        int closest = Integer.MAX_VALUE;
        int closestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < closest) {
                closest = Math.abs(nums[i]);
                closestIndex = i;
            } else if (Math.abs(nums[i]) == closest) {
                if (nums[i] > nums[closestIndex]) {
                    closest = Math.abs(nums[i]);
                    closestIndex = i;
                }
            }
        }
        return nums[closestIndex];
    }
}