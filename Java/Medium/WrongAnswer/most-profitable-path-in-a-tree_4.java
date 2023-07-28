class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] dp = new int[n];
        int[] profit = new int[n];
        dfs(0, -1, adj, dp, profit, amount);
        return profit[0];
    }

    private void dfs(int u, int p, List<List<Integer>> adj, int[] dp, int[] profit, int[] amount) {
        dp[u] = amount[u] > 0 ? 1 : -1;
        profit[u] = amount[u];
        for (int v : adj.get(u)) {
            if (v == p) {
                continue;
            }
            dfs(v, u, adj, dp, profit, amount);
            if (dp[v] > 0) {
                dp[u] += dp[v];
                profit[u] += profit[v];
            }
        }
        if (dp[u] > 0) {
            profit[u] -= dp[u] * amount[u] / 2;
        } else {
            profit[u] -= amount[u];
        }
    }
}