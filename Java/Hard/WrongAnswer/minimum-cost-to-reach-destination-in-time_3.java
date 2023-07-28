class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxTime; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = passingFees[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxTime; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                for (int[] edge : edges) {
                    if (edge[0] == i) {
                        int next = edge[1];
                        int time = edge[2];
                        if (j + time <= maxTime) {
                            if (dp[next][j + time] == -1) {
                                dp[next][j + time] = dp[i][j] + passingFees[next];
                            } else {
                                dp[next][j + time] = Math.min(dp[next][j + time], dp[i][j] + passingFees[next]);
                            }
                        }
                    }
                    if (edge[1] == i) {
                        int next = edge[0];
                        int time = edge[2];
                        if (j + time <= maxTime) {
                            if (dp[next][j + time] == -1) {
                                dp[next][j + time] = dp[i][j] + passingFees[next];
                            } else {
                                dp[next][j + time] = Math.min(dp[next][j + time], dp[i][j] + passingFees[next]);
                            }
                        }
                    }
                }
            }
        }
        int ans = -1;
        for (int i = 0; i <= maxTime; i++) {
            if (ans == -1) {
                ans = dp[n - 1][i];
            } else {
                if (dp[n - 1][i] != -1) {
                    ans = Math.min(ans, dp[n - 1][i]);
                }
            }
        }
        return ans;
    }
}