class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int[][] graph = new int[n][n];
        for (int[] connection : connections) {
            graph[connection[0]][connection[1]] = 1;
            graph[connection[1]][connection[0]] = -1;
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        return dfs(graph, visited, 0);
    }
    int dfs(int[][] graph, boolean[] visited, int node) {
        int res = 0;
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                res += 1 + dfs(graph, visited, i);
            }
            if (graph[node][i] == -1 && !visited[i]) {
                visited[i] = true;
                res += dfs(graph, visited, i);
            }
        }
        return res;
    }
}