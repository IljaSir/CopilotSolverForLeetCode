class Solution {
    public int smallestRangeII(int[] nums, int k) {
        
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[len - 1] - nums[0];
        for (int i = 0; i < len - 1; i++) {
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            int max = Math.max(nums[i] + k, nums[len - 1] - k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}