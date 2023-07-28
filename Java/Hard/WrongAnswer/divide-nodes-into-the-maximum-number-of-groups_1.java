class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0] - 1][edge[1] - 1] = 1;
            graph[edge[1] - 1][edge[0] - 1] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(graph, i, new boolean[n]));
        }
        return max;
    }

    private int dfs(int[][] graph, int i, boolean[] visited) {
        visited[i] = true;
        int max = 1;
        for (int j = 0; j < graph[i].length; j++) {
            if (graph[i][j] == 1 && !visited[j]) {
                max = Math.max(max, 1 + dfs(graph, j, visited));
            }
        }
        return max;
    }
}