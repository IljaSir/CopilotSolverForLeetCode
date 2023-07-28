class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        if (dislikes.length == 0) return true;
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, i, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, int[] visited, int node, int color) {
        if (visited[node] != 0) {
            return color == visited[node];
        }
        visited[node] = color;
        for (int nei : graph[node]) {
            if (!dfs(graph, visited, nei, -color)) {
                return false;
            }
        }
        return true;
    }
}