class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] cost = new int[n];
        int[] profit = new int[n];
        dfs(0, -1, graph, cost, profit, amount);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, profit[i] - cost[i]);
        }
        return res;
    }
    
    private void dfs(int u, int p, List<List<Integer>> graph, int[] cost, int[] profit, int[] amount) {
        int n = graph.size();
        for (int v : graph.get(u)) {
            if (v == p) {
                continue;
            }
            dfs(v, u, graph, cost, profit, amount);
            if (cost[v] < cost[u]) {
                cost[u] = cost[v];
                profit[u] = profit[v];
            } else if (cost[v] == cost[u]) {
                profit[u] = Math.max(profit[u], profit[v]);
            }
        }
        if (amount[u] < 0) {
            cost[u] -= amount[u];
        } else {
            profit[u] += amount[u];
        }
    }
}