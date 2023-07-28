class Solution {
    public int regionsBySlashes(String[] grid) {
        
        int n = grid.length;
        int[][] graph = new int[n * n * 4][n * n * 4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = (i * n + j) * 4;
                if (i > 0) {
                    graph[index][index - n * 4] = 1;
                    graph[index - n * 4][index] = 1;
                }
                if (j > 0) {
                    graph[index + 1][index + 3 - 4] = 1;
                    graph[index + 3 - 4][index + 1] = 1;
                }
                if (grid[i].charAt(j) == '/') {
                    graph[index][index + 3] = 1;
                    graph[index + 3][index] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    graph[index + 1][index + 2] = 1;
                    graph[index + 2][index + 1] = 1;
                } else {
                    graph[index][index + 3] = 1;
                    graph[index + 3][index] = 1;
                    graph[index + 1][index + 2] = 1;
                    graph[index + 2][index + 1] = 1;
                }
            }
        }
        int ans = 0;
        boolean[] visited = new boolean[n * n * 4];
        for (int i = 0; i < n * n * 4; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] graph, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == 1 && !visited[j]) {
                dfs(graph, visited, j);
            }
        }
    }
}