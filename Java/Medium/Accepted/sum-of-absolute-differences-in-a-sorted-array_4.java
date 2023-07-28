class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            res[i] = (nums[i] * i - leftSum) + (sum - leftSum - nums[i] * (n - i));
            leftSum += nums[i];
        }
        return res;
    }
}