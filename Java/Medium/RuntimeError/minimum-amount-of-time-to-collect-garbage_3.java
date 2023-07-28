class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int n = garbage.length;
        int[] M = new int[n];
        int[] P = new int[n];
        int[] G = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M') {
                    M[i]++;
                } else if (c == 'P') {
                    P[i]++;
                } else {
                    G[i]++;
                }
            }
        }
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = M[0] * travel[0];
        dp[0][1] = P[0] * travel[0];
        dp[0][2] = G[0] * travel[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]) + travel[i - 1]) + M[i] * travel[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + P[i] * travel[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + G[i] * travel[i];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}