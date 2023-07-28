class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][bob] = 0;
        dfs(graph, 0, -1, dp, amount);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
    
    private void dfs(List<Integer>[] graph, int u, int p, int[][] dp, int[] amount) {
        for (int v : graph[u]) {
            if (v != p) {
                dfs(graph, v, u, dp, amount);
                for (int i = 0; i < dp.length; i++) {
                    int cost = 0;
                    if (i == v) {
                        cost = amount[v];
                    } else if (i == 0) {
                        cost = amount[v] / 2;
                    } else if (i != u) {
                        cost = amount[v] / 2;
                    }
                    dp[u][i] = Math.max(dp[u][i], dp[v][i] + cost);
                }
            }
        }
    }
}