class Solution {
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            result = Math.max(result, nums[i] + nums[nums.length - 1 - i]);
        }
        return result;
    }
}