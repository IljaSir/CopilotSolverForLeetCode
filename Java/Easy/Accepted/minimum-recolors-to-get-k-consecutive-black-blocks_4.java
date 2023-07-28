class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (blocks.charAt(i - 1) == 'W' ? 1 : 0);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            res = Math.min(res, dp[i + k] - dp[i]);
        }
        return res;
    }
}