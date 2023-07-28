class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        int[] degree = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph[edge[0]][edge[1]] = graph[edge[1]][edge[0]] = 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (graph[i][j] == 1 && graph[i][k] == 1 && graph[j][k] == 1) {
                        res = Math.min(res, degree[i] + degree[j] + degree[k] - 6);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}