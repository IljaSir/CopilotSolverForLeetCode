class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, visited)) {
                result.add(i);
            }
        }
        return result;
    }
    private boolean dfs(int[][] graph, int node, int[] visited) {
        if (visited[node] != 0) {
            return visited[node] == 1;
        }
        visited[node] = 2;
        for (int next : graph[node]) {
            if (!dfs(graph, next, visited)) {
                return false;
            }
        }
        visited[node] = 1;
        return true;
    }
}