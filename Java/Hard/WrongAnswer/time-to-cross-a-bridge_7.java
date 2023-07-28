class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[][] dp = new int[k][n + 1];
        int[][] next = new int[k][n + 1];
        int[][] prev = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            Arrays.fill(next[i], Integer.MAX_VALUE);
            Arrays.fill(prev[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < k; i++) {
            dp[i][0] = time[i][0] + time[i][2];
            next[i][0] = time[i][2];
            prev[i][0] = time[i][0];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                int minIdx = -1;
                for (int l = 0; l < k; l++) {
                    if (prev[l][i - 1] + time[l][1] + time[l][2] < min) {
                        min = prev[l][i - 1] + time[l][1] + time[l][2];
                        minIdx = l;
                    }
                }
                dp[j][i] = min + time[j][3];
                next[j][i] = min + time[j][3];
                prev[j][i] = min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, dp[i][n]);
        }
        return min;
    }
}