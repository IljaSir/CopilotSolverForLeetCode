class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += (nums[i] - nums[i - 1]) * i;
        }
        res[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i] - nums[i - 1];
            sum -= (nums.length - i) * (nums[i] - nums[i - 1]);
            res[i] = sum;
        }
        return res;
    }
}