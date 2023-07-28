class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
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
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        dp[bob][1] = 0;
        dfs(graph, amount, dp, 0, -1);
        return dp[0][0];
    }
    
    private int dfs(List<List<Integer>> graph, int[] amount, int[][] dp, int u, int p) {
        if (dp[u][0] != Integer.MIN_VALUE) {
            return dp[u][0];
        }
        int res = 0;
        for (int v : graph.get(u)) {
            if (v == p) {
                continue;
            }
            res = Math.max(res, dfs(graph, amount, dp, v, u));
        }
        res += amount[u];
        dp[u][0] = res;
        return res;
    }
}