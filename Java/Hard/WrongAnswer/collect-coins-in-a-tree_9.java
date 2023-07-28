class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        if (n == 1) return 0;
        int[] dp = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(0, -1, coins, dp, graph);
    }
    private int dfs(int u, int f, int[] coins, int[] dp, List<List<Integer>> graph) {
        dp[u] = coins[u];
        int max = 0;
        for (int v : graph.get(u)) {
            if (v == f) continue;
            int tmp = dfs(v, u, coins, dp, graph);
            dp[u] += dp[v];
            max = Math.max(max, tmp);
        }
        return max + dp[u] - 1;
    }
}