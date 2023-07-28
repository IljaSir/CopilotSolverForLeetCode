class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        int[][] graph = new int[n][n];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[n];
        for (int i = 0; i < n; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] group, int i, int g) {
        if (group[i] != 0) {
            return group[i] == g;
        }
        group[i] = g;
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j] == 1 && !dfs(graph, group, j, -g)) {
                return false;
            }
        }
        return true;
    }
}