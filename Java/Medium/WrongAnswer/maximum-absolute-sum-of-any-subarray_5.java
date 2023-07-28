class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + nums[i];
        }
        int max = Math.max(Math.abs(pre[0]), Math.abs(suf[0]));
        int min = Math.min(Math.abs(pre[0]), Math.abs(suf[0]));
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.abs(pre[i]));
            min = Math.min(min, Math.abs(pre[i]));
            max = Math.max(max, Math.abs(suf[i]));
            min = Math.min(min, Math.abs(suf[i]));
        }
        return max;
    }
}