class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ans[0] += nums[i] - nums[0];
            sum += nums[i];
        }
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + (nums[i] - nums[i - 1]) * i - (sum - nums[i] * (n - i));
        }
        return ans;
    }
}