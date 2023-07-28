class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return dfs(0, graph, hasApple, visited);
    }
    private int dfs(int node, Map<Integer, List<Integer>> graph, List<Boolean> hasApple, Set<Integer> visited) {
        int time = 0;
        if (hasApple.get(node)) {
            time += 2;
        }
        for (int neighbor : graph.get(node)) {
            if (visited.contains(neighbor)) {
                continue;
            }
            visited.add(neighbor);
            time += dfs(neighbor, graph, hasApple, visited);
        }
        return time;
    }
}