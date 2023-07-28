class Solution {
    public int maximumProduct(int[] nums) {
        
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        if (nums[0] < 0 && nums[1] < 0) {
            res = Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
        } else {
            res = nums[n - 1] * nums[n - 2] * nums[n - 3];
        }
        return res;
    }
}