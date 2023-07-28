class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ans[0] += nums[i];
        }
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] - (n - i) * nums[i - 1] + (i) * nums[i - 1];
        }
        return ans;
    }
}