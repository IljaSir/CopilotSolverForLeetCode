class Solution {
    public int maxTwoEvents(int[][] events) {
        
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(events, dp, 0, -1);
    }
    private int dfs(int[][] events, int[][] dp, int idx, int last) {
        if (idx == events.length) {
            return 0;
        }
        if (dp[idx][last + 1] != -1) {
            return dp[idx][last + 1];
        }
        int res = dfs(events, dp, idx + 1, last);
        if (last == -1 || events[idx][0] > events[last][1]) {
            res = Math.max(res, events[idx][2] + dfs(events, dp, idx + 1, idx));
        }
        return dp[idx][last + 1] = res;
    }
}