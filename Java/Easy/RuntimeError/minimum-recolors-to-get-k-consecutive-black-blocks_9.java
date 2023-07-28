class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] count = new int[n];
        int[] sum = new int[n];
        int[] dp = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            count[i] = blocks.charAt(i) == 'W' ? 1 : 0;
            sum[i] = count[i] + (i > 0 ? sum[i - 1] : 0);
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                pre[i] = Math.min(pre[i - 1], dp[i - k]);
            }
            dp[i] = (i > 0 ? pre[i - 1] : 0) + sum[i] - (i >= k ? sum[i - k] : 0);
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            if (i + k - 1 < n) {
                suf[i] = Math.min(suf[i + 1], dp[i + k]);
            }
            dp[i] = (i + 1 < n ? suf[i + 1] : 0) + sum[n - 1] - sum[i] - (i + k - 1 < n ? sum[i + k - 1] : 0);
            if (i + k - 1 < n) {
                ans = Math.min(ans, dp[i]);
            }
        }
        return ans;
    }
}