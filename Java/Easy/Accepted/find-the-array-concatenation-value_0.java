class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        long ans = 0;
        while (nums.length > 1) {
            ans += nums[0] * Math.pow(10, (int)Math.log10(nums[nums.length - 1]) + 1) + nums[nums.length - 1];
            nums = Arrays.copyOfRange(nums, 1, nums.length - 1);
        }
        if (nums.length == 1) ans += nums[0];
        return ans;
    }
}