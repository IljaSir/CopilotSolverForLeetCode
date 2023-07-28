class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int[] x = new int[n];
        int[] y = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = bombs[i][0];
            y[i] = bombs[i][1];
            r[i] = bombs[i][2];
        }
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2) > Math.pow(r[i] + r[j], 2)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}