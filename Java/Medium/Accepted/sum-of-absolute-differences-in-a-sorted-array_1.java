class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int leftSum = sum[i] - nums[i];
            int rightSum = sum[n - 1] - sum[i];
            result[i] = i * nums[i] - leftSum + rightSum - (n - i - 1) * nums[i];
        }
        return result;
    }
}