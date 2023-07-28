class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }

        int[] sub = new int[n];
        dfs(adj, sub, 0, -1);

        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        dfs(adj, dp, sub, 0, -1, seats);
        return dp[0];
    }

    private void dfs(List<Integer>[] adj, int[] sub, int u, int p) {
        sub[u] = 1;
        for (int v : adj[u]) {
            if (v == p) {
                continue;
            }
            dfs(adj, sub, v, u);
            sub[u] += sub[v];
        }
    }

    private void dfs(List<Integer>[] adj, long[] dp, int[] sub, int u, int p, int seats) {
        for (int v : adj[u]) {
            if (v == p) {
                continue;
            }
            dfs(adj, dp, sub, v, u, seats);
            dp[u] += dp[v] + sub[v];
        }

        long min = Long.MAX_VALUE;
        for (int v : adj[u]) {
            if (v == p) {
                continue;
            }
            min = Math.min(min, dp[u] - dp[v] - sub[v] + dp[v] + (sub[v] + seats - 1) / seats);
        }
        dp[u] = Math.min(dp[u], min);
    }
}