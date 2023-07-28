class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int rob = 0;
        int notRob = 0;
        for (int i = start; i <= end; i++) {
            int curRob = notRob + nums[i];
            notRob = Math.max(notRob, rob);
            rob = curRob;
        }
        return Math.max(rob, notRob);
    }
}