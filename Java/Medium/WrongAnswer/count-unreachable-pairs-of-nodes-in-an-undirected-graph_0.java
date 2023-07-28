class Solution {
    public long countPairs(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];
            dfs(graph, i, visited);
            for (int j = 0; j < n; j++) {
                if (visited[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(Map<Integer, Set<Integer>> graph, int node, int[] visited) {
        visited[node] = 1;
        for (int neighbor : graph.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}