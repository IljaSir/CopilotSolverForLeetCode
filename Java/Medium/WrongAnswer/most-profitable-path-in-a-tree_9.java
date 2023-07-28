class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        int res = amount[0];
        dfs(g, 0, -1, dp, dp2, amount, bob, res);
        return res;
    }
    void dfs(List<List<Integer>> g, int u, int p, int[] dp, int[] dp2, int[] amount, int bob, int res) {
        dp[u] = amount[u];
        for (int v : g.get(u)) {
            if (v == p) continue;
            dfs(g, v, u, dp, dp2, amount, bob, res);
            if (dp[v] > 0) {
                dp[u] += dp[v];
            }
        }
        if (u == bob) {
            dp2[u] = dp[u];
            return;
        }
        int max = 0;
        for (int v : g.get(u)) {
            if (v == p) continue;
            max = Math.max(max, dp2[v]);
        }
        dp2[u] = max;
        res = Math.max(res, dp[u] - dp2[u]);
    }
}