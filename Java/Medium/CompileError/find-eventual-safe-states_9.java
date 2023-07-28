class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> resut = new ArrayList<>();
        int[] visited = newint[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, visited, i)) {
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean dfs(int[][] graph, int[] visited, int i) {
        if (visited[i] > 0) {
            return visited[i] == 2;
        }
        visited[i] = 1;
        for (int j : graph[i]) {
            if (!dfs(graph, visited, j)) {
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }
}