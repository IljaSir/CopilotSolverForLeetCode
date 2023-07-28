class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, 0, visited, hasApple);
    }
    
    private int dfs(Map<Integer, List<Integer>> graph, int curr, boolean[] visited, List<Boolean> hasApple) {
        visited[curr] = true;
        int time = 0;
        for (int next : graph.get(curr)) {
            if (!visited[next]) {
                time += dfs(graph, next, visited, hasApple);
            }
        }
        if (time == 0) {
            return hasApple.get(curr) ? 2 : 0;
        } else {
            return time + 2;
        }
    }
}