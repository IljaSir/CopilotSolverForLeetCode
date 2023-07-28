class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int n = garbage.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < 3; i++) {
            if (garbage[0].indexOf("MPG".charAt(i)) != -1) {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (garbage[i].indexOf("MPG".charAt(j)) != -1) {
                    for (int k = 0; k < 3; k++) {
                        if (dp[i - 1][k] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + travel[i - 1]);
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}