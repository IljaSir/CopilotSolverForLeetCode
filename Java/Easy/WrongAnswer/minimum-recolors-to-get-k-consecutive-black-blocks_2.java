class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] psum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            psum[i + 1] = psum[i] + (blocks.charAt(i) == 'B' ? 1 : 0);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + (blocks.charAt(i) == 'B' ? 0 : 1);
            if (i + 1 >= k) {
                int t = psum[i + 1] - psum[i + 1 - k];
                if (t < k) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[i + 1 - k] + k - t);
                }
            }
        }
        return dp[n];
    }
}