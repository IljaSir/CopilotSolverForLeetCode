class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] degree = new int[n + 1];
        for (int u = 1; u <= n; u++) {
            degree[u] = graph.get(u).size();
        }
        int odd = 0;
        for (int u = 1; u <= n; u++) {
            if (degree[u] % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0) {
            return true;
        }
        if (odd % 2 == 1) {
            return false;
        }
        int[] color = new int[n + 1];
        for (int u = 1; u <= n; u++) {
            if (degree[u] % 2 == 1) {
                if (!dfs(graph, degree, color, u, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, Set<Integer>> graph, int[] degree, int[] color, int u, int c) {
        color[u] = c;
        for (int v : graph.get(u)) {
            if (color[v] == c) {
                return false;
            }
            if (color[v] == 0 && !dfs(graph, degree, color, v, -c)) {
                return false;
            }
        }
        return true;
    }
}