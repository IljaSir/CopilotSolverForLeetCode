class Solution {
    public int waysToBuildRooms(int[] prevRoom) {
        
        int mod = 1000000007;
        int n = prevRoom.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[prevRoom[i]].add(i);
        }
        long[] dp = new long[n];
        dfs(adj, 0, dp);
        return (int) dp[0];
    }
    private long dfs(List<Integer>[] adj, int u, long[] dp) {
        if (dp[u] > 0) {
            return dp[u];
        }
        dp[u] = 1;
        for (int v : adj[u]) {
            dp[u] = dp[u] * (dfs(adj, v, dp) + 1) % 1000000007;
        }
        return dp[u];
    }
}