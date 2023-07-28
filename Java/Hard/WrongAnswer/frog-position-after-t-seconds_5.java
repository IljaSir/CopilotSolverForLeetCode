class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        if (n == 1) {
            return 1.0;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new HashSet<>()).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(graph, visited, 1, t, target);
    }
    private double dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int node, int t, int target) {
        if (t == 0) {
            return node == target ? 1.0 : 0.0;
        }
        visited.add(node);
        Set<Integer> neighbors = graph.get(node);
        if (neighbors == null || neighbors.isEmpty()) {
            return node == target ? 1.0 : 0.0;
        }
        int count = 0;
        for (int neighbor : neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }
            count++;
        }
        double result = 0.0;
        for (int neighbor : neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }
            result += dfs(graph, visited, neighbor, t - 1, target) / count;
        }
        visited.remove(node);
        return result;
    }
}