class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        int min = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            graph[i][j] = 0;
            graph[j][i] = 0;
            min = Math.min(min, dfs(graph, i, j, 1, new boolean[n]));
            graph[i][j] = 1;
            graph[j][i] = 1;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int dfs(int[][] graph, int i, int j, int len, boolean[] visited) {
        if (i == j) {
            return len;
        }
        visited[i] = true;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < graph.length; k++) {
            if (graph[i][k] == 1 && !visited[k]) {
                min = Math.min(min, dfs(graph, k, j, len + 1, visited));
            }
        }
        visited[i] = false;
        return min;
    }
}