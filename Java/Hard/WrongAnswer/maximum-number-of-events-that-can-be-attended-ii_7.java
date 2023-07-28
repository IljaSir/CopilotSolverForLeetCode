class Solution {
    public int maxValue(int[][] events, int k) {
        
        Arrays.sort(events, (a, b) -> (a[1] - b[1]));
        int n = events.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 0; i < n; i++) {
            int s = events[i][0];
            for (int j = i + 1; j < n; j++) {
                if (events[j][0] > s) {
                    next[i] = j;
                    break;
                }
            }
        }
        dp[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            int j = next[i];
            if (j == -1) {
                dp[i] = Math.max(dp[i + 1], events[i][2]);
            } else {
                dp[i] = Math.max(dp[i + 1], events[i][2] + dp[j]);
            }
        }
        int[][] memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(events, dp, next, 0, k, memo);
    }

    private int dfs(int[][] events, int[] dp, int[] next, int i, int k, int[][] memo) {
        if (i == events.length || k == 0) {
            return 0;
        }
        if (memo[i][k] != -1) {
            return memo[i][k];
        }
        int j = next[i];
        int ans = 0;
        if (j == -1) {
            ans = Math.max(ans, dp[i]);
        } else {
            ans = Math.max(ans, dp[i] + dfs(events, dp, next, j, k - 1, memo));
        }
        ans = Math.max(ans, dfs(events, dp, next, i + 1, k, memo));
        memo[i][k] = ans;
        return ans;
    }
}