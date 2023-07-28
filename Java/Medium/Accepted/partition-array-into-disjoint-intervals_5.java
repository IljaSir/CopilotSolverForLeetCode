class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int[] maxLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            maxLeft[i] = max;
        }
        int min = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minRight[i] = min;
        }
        for (int i = 1; i < nums.length; i++) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return -1;
    }
}