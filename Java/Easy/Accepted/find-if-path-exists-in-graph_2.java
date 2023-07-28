class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return dfs(source, destination, graph, new boolean[n]);
    }
    
    private boolean dfs(int curr, int destination, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (curr == destination) return true;
        if (visited[curr]) return false;
        visited[curr] = true;
        List<Integer> adjacents = graph.getOrDefault(curr, new ArrayList<>());
        for (Integer adjacent : adjacents) {
            if (dfs(adjacent, destination, graph, visited)) return true;
        }
        return false;
    }
}