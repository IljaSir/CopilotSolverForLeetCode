class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] result = new int[2];
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int sum2 = (n * (n + 1) * (2 * n + 1)) / 6;
        int sum3 = 0;
        int sum4 = 0;
        for (int i = 0; i < n; i++) {
            sum3 += nums[i];
            sum4 += nums[i] * nums[i];
        }
        result[1] = (sum3 - sum + sum4 / sum3) / 2;
        result[0] = sum3 - sum + sum4 / sum3 - result[1];
        return result;
    }
}