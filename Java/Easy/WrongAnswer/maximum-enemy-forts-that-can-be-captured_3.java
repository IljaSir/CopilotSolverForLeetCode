class Solution {
    public int captureForts(int[] forts) {
        
        int n = forts.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 0) {
                dp[i] = 1;
                continue;
            }
            if (i > 0 && forts[i - 1] == 0) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}