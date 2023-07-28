class Solution {
    public int findClosestNumber(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs < min) {
                min = abs;
                res = nums[i];
            } else if (abs == min) {
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }
}