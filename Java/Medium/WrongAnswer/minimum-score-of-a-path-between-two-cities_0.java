class Solution {
    public int minScore(int n, int[][] roads) {
        
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for (int[] road : roads) {
            int a = road[0] - 1;
            int b = road[1] - 1;
            graph[a][b] = road[2];
            graph[b][a] = road[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], Math.max(graph[i][k], graph[k][j]));
                    }
                }
            }
        }
        return graph[0][n - 1];
    }
}