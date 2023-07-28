class Solution {
    public long subArrayRanges(int[] nums) {
        
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
            suf[n - 1 - i] = Math.min(suf[n - i], nums[n - 1 - i]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (i + 1) * (n - i) * (pre[i] - suf[i]);
        }
        return ans;
    }
}