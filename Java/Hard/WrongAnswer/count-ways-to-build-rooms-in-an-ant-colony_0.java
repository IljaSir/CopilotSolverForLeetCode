class Solution {
    public int waysToBuildRooms(int[] prevRoom) {
        
        int n = prevRoom.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            g[prevRoom[i]].add(i);
        }
        int[] size = new int[n];
        int[] depth = new int[n];
        dfs(g, size, depth, 0);
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % 1000000007);
        }
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (int) ((long) pow[i - 1] * 2 % 1000000007);
        }
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int s = size[i];
            dp[i] = fact[s - 1];
            for (int j : g[i]) {
                dp[i] = (int) ((long) dp[i] * dp[j] % 1000000007);
            }
            dp[i] = (int) ((long) dp[i] * pow[depth[i]] % 1000000007);
        }
        return dp[0];
    }
    void dfs(List<Integer>[] g, int[] size, int[] depth, int u) {
        size[u] = 1;
        for (int v : g[u]) {
            depth[v] = depth[u] + 1;
            dfs(g, size, depth, v);
            size[u] += size[v];
        }
    }
}