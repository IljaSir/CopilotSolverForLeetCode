class Solution {
    public int minimumDifference(int[] nums, int k) {
        
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - k; i++) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}