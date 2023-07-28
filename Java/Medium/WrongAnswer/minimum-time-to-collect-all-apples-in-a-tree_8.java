class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        int[] parent = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            parent[v] = u;
            graph[u].add(v);
        }
        boolean[] visited = new boolean[n];
        return dfs(0, graph, hasApple, visited, parent);
    }
    
    private int dfs(int u, List<Integer>[] graph, List<Boolean> hasApple, boolean[] visited, int[] parent) {
        if (visited[u]) {
            return 0;
        }
        visited[u] = true;
        int ans = 0;
        for (int v : graph[u]) {
            ans += dfs(v, graph, hasApple, visited, parent);
        }
        if (ans == 0 && !hasApple.get(u)) {
            return 0;
        }
        if (u == 0) {
            return ans;
        }
        return ans + 2;
    }
}