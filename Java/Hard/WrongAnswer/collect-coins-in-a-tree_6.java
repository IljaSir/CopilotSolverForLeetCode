class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        int[] dp = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(graph, coins, dp, 0, -1);
        return dp[0];
    }
    private void dfs(List<List<Integer>> graph, int[] coins, int[] dp, int cur, int parent) {
        for (int next : graph.get(cur)) {
            if (next != parent) {
                dfs(graph, coins, dp, next, cur);
                dp[cur] += dp[next];
            }
        }
        dp[cur] += coins[cur];
    }
}