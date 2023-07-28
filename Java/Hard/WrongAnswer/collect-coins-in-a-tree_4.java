class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] ans = new int[1];
        boolean[] visited = new boolean[n];
        dfs(0, coins, graph, ans, visited);
        return ans[0];
    }
    
    private int dfs(int u, int[] coins, List<Integer>[] graph, int[] ans, boolean[] visited) {
        visited[u] = true;
        int cur = coins[u];
        for (int v : graph[u]) {
            if (!visited[v]) {
                cur += dfs(v, coins, graph, ans, visited);
            }
        }
        ans[0] += Math.abs(cur);
        return cur;
    }
}