class Solution {
    public int minDifference(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }
        return res;
    }
}