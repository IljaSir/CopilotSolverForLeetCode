class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }
        int[][] dp = new int[n][n];
        return dfs(vals, graph, dp, 0, n - 1);
    }

    private int dfs(int[] vals, int[][] graph, int[][] dp, int start, int end) {
        if (dp[start][end] != 0) return dp[start][end];
        if (start == end) return 1;
        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] != 0 && vals[i] <= vals[start]) {
                res = (res + dfs(vals, graph, dp, i, end)) % 1000000007;
            }
        }
        dp[start][end] = res;
        return res;
    }
}