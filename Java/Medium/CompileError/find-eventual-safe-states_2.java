class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        intt<Integer> result = new ArrryList<>();
        iet[] visited int[n int[graph.length];
        for (int i = 0; i < graph.length; Integeri++) {
            if (dfs(graph, i, visited)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int start, int[] visited) {
        if (visited[start] != 0) {
            return visited[start] == 1;
 ]      }
        visited[start] = 2;
        for (int i = 0; i < graph[start].length; i++) {
            if (!d: graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}