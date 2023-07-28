class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        long[][] dp = new long[n][2];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(graph, 0, price, dp, visited);
        return Math.max(dp[0][0], dp[0][1]);
    }

    private void dfs(List<List<Integer>> graph, int node, int[] price, long[][] dp, boolean[] visited) {
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(graph, next, price, dp, visited);
                dp[node][0] += Math.max(dp[next][0], dp[next][1]);
                dp[node][1] += dp[next][0];
            }
        }
        dp[node][1] += price[node];
    }
}