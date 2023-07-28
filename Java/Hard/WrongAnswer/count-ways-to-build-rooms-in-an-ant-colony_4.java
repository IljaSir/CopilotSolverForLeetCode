class Solution {
    public int waysToBuildRooms(int[] prevRoom) {
        
        int n = prevRoom.length;
        int mod = 1000000007;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; ++i) {
            adj[prevRoom[i]].add(i);
        }
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; ++i) {
            fact[i] = (int) ((long) fact[i - 1] * i % mod);
        }
        int[] size = new int[n];
        dfs(adj, 0, size);
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = fact[size[i]];
            for (int j : adj[i]) {
                dp[i] = (int) ((long) dp[i] * dp[j] % mod);
            }
        }
        return dp[n - 1];
    }

    public void dfs(List<Integer>[] adj, int u, int[] size) {
        size[u] = 1;
        for (int v : adj[u]) {
            dfs(adj, v, size);
            size[u] += size[v];
        }
    }
}