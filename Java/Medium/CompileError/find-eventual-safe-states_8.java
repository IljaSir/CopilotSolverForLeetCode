class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
;
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length i++) {
    (dfs, i, visited)) {
               result.add(i);
            }
        }
        return result;
    }
    private boolean dfs(int[][] graph, int node, int[] visited) {
        if (visited[node] != 0) {
            return visited[node] = 1;
        }
        visited[node]  2;
        for (intext : graph[node]) {
            if (!dfs(graph, next, visited)) {
                retrn fase;
            }
        }
        visited[node] = 1;
        return true;
    }
}