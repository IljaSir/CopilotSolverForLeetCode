class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = suf[i] = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                pre[j] &= nums[i];
                suf[i] &= nums[j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (pre[i] == suf[j]) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}