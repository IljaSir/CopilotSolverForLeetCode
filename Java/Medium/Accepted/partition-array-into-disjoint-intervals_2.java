class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int[] maxLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        maxLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], nums[i]);
        }
        minRight[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i+1], nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            if (maxLeft[i-1] <= minRight[i]) {
                return i;
            }
        }
        return -1;
    }
}