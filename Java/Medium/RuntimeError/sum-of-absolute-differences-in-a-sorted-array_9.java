class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + nums[i];
            suf[n-i-1] = suf[n-i] + nums[n-i-1];
        }
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n-1-i;
            int leftSum = left * nums[i] - (left == 0 ? 0 : pre[left-1]);
            int rightSum = suf[i+1] - right * nums[i];
            ans[i] = leftSum + rightSum;
        }
        return ans;
    }
}