class Solution {
    public int findClosestNumber(int[] nums) {
        
        int closest = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int distance = Math.abs(nums[i]);
            if (distance < min) {
                min = distance;
                closest = nums[i];
            }
            else if (distance == min) {
                if (nums[i] > closest) {
                    closest = nums[i];
                }
            }
        }
        return closest;
    }
}