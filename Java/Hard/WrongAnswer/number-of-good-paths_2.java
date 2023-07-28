class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(vals, graph, dp, 0, n - 1);
    }
    private int dfs(int[] vals, int[][] graph, int[][] dp, int start, int end) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (vals[start] != vals[end]) {
            dp[start][end] = 0;
            return 0;
        }
        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] == 1 && vals[i] <= vals[start]) {
                res += dfs(vals, graph, dp, i, end);
                res %= 1000000007;
            }
        }
        dp[start][end] = res;
        return res;
    }
}