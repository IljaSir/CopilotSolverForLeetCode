class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(graph, source, destination, visited);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination, Set<Integer> visited) {
        if (source == destination) {
            return true;
        }
        visited.add(source);
        for (int neighbor : graph.get(source)) {
            if (!visited.contains(neighbor) && dfs(graph, neighbor, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}