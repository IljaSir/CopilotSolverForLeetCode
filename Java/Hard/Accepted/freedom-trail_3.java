class Solution {
    public int findRotateSteps(String ring, String key) {
        
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            if (ring.charAt(i) == key.charAt(0)) {
                dp[0][i] = Math.min(i, n - i) + 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ring.charAt(j) != key.charAt(i)) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) != key.charAt(i - 1)) {
                        continue;
                    }
                    int diff = Math.abs(j - k);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(diff, n - diff) + 1);
                }
            }
        }
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m - 1][i]);
        }
        return ans;
    }
}