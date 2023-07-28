class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(0, visited, coins, graph);
    }
    private int dfs(int u, boolean[] visited, int[] coins, List<List<Integer>> graph) {
        int res = 0;
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                res += dfs(v, visited, coins, graph);
            }
        }
        if (u == 0) {
            return res;
        }
        if (coins[u] == 1) {
            if (coins[u - 1] == 0) {
                coins[u - 1] = 1;
                coins[u] = 0;
                res++;
            }
        } else if (coins[u - 1] == 1) {
            coins[u - 1] = 0;
            coins[u] = 1;
            res++;
        }
        return res;
    }
}