class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        // build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // count degree
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            degree[i] = graph.get(i).size();
        }
        
        // remove odd degree nodes
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                if (!dfs(graph, degree, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, Set<Integer>> graph, int[] degree, boolean[] visited, int node) {
        if (degree[node] % 2 == 1) {
            visited[node] = true;
            for (int next : graph.get(node)) {
                if (visited[next]) {
                    continue;
                }
                degree[node]--;
                degree[next]--;
                if (!dfs(graph, degree, visited, next)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}