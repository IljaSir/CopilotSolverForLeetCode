class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = passingFees[0];
        int res = dfs(0, maxTime, graph, passingFees, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int cur, int time, int[][] graph, int[] fees, int[][] dp) {
        if (dp[cur][time] != -1) {
            return dp[cur][time];
        }
        int n = graph.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (graph[cur][i] != -1 && graph[cur][i] <= time) {
                res = Math.min(res, dfs(i, time - graph[cur][i], graph, fees, dp) + fees[i]);
            }
        }
        dp[cur][time] = res;
        return res;
    }
}