class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(graph, count, dp, coins, 0, -1);
        return dp[0];
    }

    private void dfs(List<List<Integer>> graph, int[] count, int[] dp, int[] coins, int u, int p) {
        for (int v : graph.get(u)) {
            if (v == p) {
                continue;
            }
            dfs(graph, count, dp, coins, v, u);
            count[u] += count[v];
            dp[u] += dp[v];
        }
        count[u] += coins[u];
        dp[u] += Math.abs(count[u] - 1);
    }
}