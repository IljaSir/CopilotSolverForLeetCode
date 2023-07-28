class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * min));
            res = Math.max(res, max);
        }
        return res;
    }
}