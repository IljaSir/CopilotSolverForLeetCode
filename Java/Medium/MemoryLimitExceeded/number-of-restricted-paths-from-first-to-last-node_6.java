class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] e : edges) {
            graph[e[0] - 1][e[1] - 1] = e[2];
            graph[e[1] - 1][e[0] - 1] = e[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n - 1] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int minIndex = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (minIndex == -1 || dist[j] < dist[minIndex])) {
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            for (int j = 0; j < n; j++) {
                if (graph[minIndex][j] != -1) {
                    dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
                }
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 1;
        return dfs(graph, dist, dp, 0);
    }
    
    private int dfs(int[][] graph, int[] dist, int[] dp, int index) {
        if (dp[index] != -1) {
            return dp[index];
        }
        dp[index] = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] != -1 && dist[index] > dist[i]) {
                dp[index] = (dp[index] + dfs(graph, dist, dp, i)) % 1000000007;
            }
        }
        return dp[index];
    }
}