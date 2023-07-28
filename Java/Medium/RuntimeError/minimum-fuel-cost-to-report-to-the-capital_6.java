class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dfs(0, adj, dp, seats);
        return dp[0] - 1;
    }
    private void dfs(int u, List<List<Integer>> adj, long[] dp, int seats) {
        dp[u] = 0;
        for (int v : adj.get(u)) {
            dfs(v, adj, dp, seats);
            dp[u] += dp[v];
        }
        dp[u] = (dp[u] + seats - 1) / seats;
    }
}