class Solution {
    public int minScore(int n, int[][] roads) {
        
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int[] r : roads) {
            graph[r[0]][r[1]] = Math.min(graph[r[0]][r[1]], r[2]);
            graph[r[1]][r[0]] = Math.min(graph[r[1]][r[0]], r[2]);
        }
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    graph[i][j] = Math.min(graph[i][j], Math.max(graph[i][k], graph[k][j]));
                }
            }
        }
        return graph[1][n];
    }
}