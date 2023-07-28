class Solution {
    public int partitionDisjoint(int[] nums) {
        
        int[] max_left = new int[nums.length];
        int[] min_right = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            max_left[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            min_right[i] = min;
        }
        for (int i = 0; i < nums.length; i++) {
            if (max_left[i] <= min_right[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }
}