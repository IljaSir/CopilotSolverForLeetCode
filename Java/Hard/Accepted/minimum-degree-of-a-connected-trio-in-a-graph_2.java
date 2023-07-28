class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        int[][] graph = new int[n + 1][n + 1];
        int[] degree = new int[n + 1];
        for (int[] e : edges) {
            graph[e[0]][e[1]] = 1;
            graph[e[1]][e[0]] = 1;
            degree[e[0]]++;
            degree[e[1]]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (graph[i][j] == 0) continue;
                for (int k = j + 1; k <= n; k++) {
                    if (graph[i][k] == 0 || graph[j][k] == 0) continue;
                    int d = degree[i] + degree[j] + degree[k] - 6;
                    min = Math.min(min, d);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}