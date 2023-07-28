class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] dp = new int[n];
        dfs(graph, dp, coins, 0, -1);
        return dp[0];
    }

    private void dfs(List<Integer>[] graph, int[] dp, int[] coins, int u, int p) {
        dp[u] = coins[u];
        for (int v : graph[u]) {
            if (v != p) {
                dfs(graph, dp, coins, v, u);
                dp[u] += dp[v];
            }
        }
    }
}