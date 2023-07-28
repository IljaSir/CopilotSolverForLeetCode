class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(graph, amount, dp, 0, visited);
        return dp[bob];
    }
    
    private void dfs(int[][] graph, int[] amount, int[] dp, int cur, boolean[] visited) {
        if (graph[cur][0] == 1 && !visited[0]) {
            dp[0] = Math.max(dp[0], dp[cur] + amount[cur] / 2);
            visited[0] = true;
            dfs(graph, amount, dp, 0, visited);
            visited[0] = false;
        }
        for (int i = 1; i < graph.length; i++) {
            if (graph[cur][i] == 1 && !visited[i]) {
                dp[i] = Math.max(dp[i], dp[cur] + amount[cur] / 2);
                visited[i] = true;
                dfs(graph, amount, dp, i, visited);
                visited[i] = false;
            }
        }
    }
}