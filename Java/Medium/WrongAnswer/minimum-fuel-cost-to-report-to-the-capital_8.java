class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        long[][] dp = new long[n][seats + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }
        dp[0][1] = 0;
        dfs(graph, dp, 0, -1, seats);
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= seats; ++i) {
            ans = Math.min(ans, dp[0][i]);
        }
        return ans;
    }

    private void dfs(List<List<Integer>> graph, long[][] dp, int u, int p, int seats) {
        for (int v : graph.get(u)) {
            if (v == p) {
                continue;
            }
            dfs(graph, dp, v, u, seats);
            for (int i = seats; i >= 1; --i) {
                for (int j = 1; j <= i; ++j) {
                    dp[u][i] = Math.min(dp[u][i], dp[u][i - j] + dp[v][j]);
                }
            }
            dp[u][1] += 1;
        }
    }
}