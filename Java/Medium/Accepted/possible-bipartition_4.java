class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        int[][] graph = new int[n+1][n+1];
        for (int[] d : dislikes) {
            graph[d[0]][d[1]] = 1;
            graph[d[1]][d[0]] = 1;
        }
        int[] group = new int[n+1];
        for (int i = 1; i <= n; i++) {
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
        for (int j = 1; j < graph.length; j++) {
            if (graph[i][j] == 1 && !dfs(graph, group, j, -g)) {
                return false;
            }
        }
        return true;
    }
}