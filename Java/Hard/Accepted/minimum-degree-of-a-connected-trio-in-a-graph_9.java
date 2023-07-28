class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        int[] degree = new int[n+1];
        int[][] graph = new int[n+1][n+1];
        int min = Integer.MAX_VALUE;
        for(int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                if(graph[i][j] == 1) {
                    for(int k = j+1; k <= n; k++) {
                        if(graph[i][k] == 1 && graph[j][k] == 1) {
                            min = Math.min(min, degree[i]+degree[j]+degree[k]-6);
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}