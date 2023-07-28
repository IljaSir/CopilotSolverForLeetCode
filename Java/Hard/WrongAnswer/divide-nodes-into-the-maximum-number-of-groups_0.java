class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0] - 1][edge[1] - 1] = 1;
            graph[edge[1] - 1][edge[0] - 1] = 1;
        }
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] graph, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == 1 && visited[j] == 0) {
                dfs(graph, visited, j);
            }
        }
    }
}