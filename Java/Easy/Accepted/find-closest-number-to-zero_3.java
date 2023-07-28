class Solution {
    public int findClosestNumber(int[] nums) {
        
        int closest = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int distance = Math.abs(nums[i]);
            if (distance < minDistance) {
                closest = nums[i];
                minDistance = distance;
            } else if (distance == minDistance && nums[i] > closest) {
                closest = nums[i];
            }
        }
        return closest;
    }
}