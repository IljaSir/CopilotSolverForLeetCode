class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(graph, visited, hasApple, 0);
    }
    
    private int dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, List<Boolean> hasApple, int node) {
        visited.add(node);
        int time = 0;
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                time += dfs(graph, visited, hasApple, neighbor);
            }
        }
        if (time > 0 || hasApple.get(node)) {
            time += 2;
        }
        return time;
    }
}