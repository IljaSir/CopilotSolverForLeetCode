class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[][] dp = new int[n][2];
        dfs(graph, amount, dp, 0, -1);
        return dp[0][bob];
    }
    private void dfs(List<Integer>[] graph, int[] amount, int[][] dp, int u, int p) {
        for (int v : graph[u]) {
            if (v == p) {
                continue;
            }
            dfs(graph, amount, dp, v, u);
            dp[u][0] += Math.max(dp[v][0], dp[v][1]);
            dp[u][1] += dp[v][0];
        }
        dp[u][0] += amount[u] > 0 ? amount[u] / 2 : 0;
        dp[u][1] += amount[u] < 0 ? amount[u] / 2 : 0;
    }
}