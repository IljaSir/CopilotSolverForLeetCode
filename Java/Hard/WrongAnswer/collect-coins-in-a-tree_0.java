class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int n = coins.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] dp = new int[n];
        dfs(graph, coins, dp, 0, -1);
        return dp[0];
    }
    private void dfs(List<Integer>[] graph, int[] coins, int[] dp, int cur, int parent) {
        dp[cur] = coins[cur];
        for (int next : graph[cur]) {
            if (next == parent) {
                continue;
            }
            dfs(graph, coins, dp, next, cur);
            dp[cur] += dp[next];
        }
    }
}