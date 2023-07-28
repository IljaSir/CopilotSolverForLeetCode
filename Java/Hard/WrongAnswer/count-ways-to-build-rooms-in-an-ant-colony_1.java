class Solution {
    public int waysToBuildRooms(int[] prevRoom) {
        
        int mod = 1000000007;
        int n = prevRoom.length;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            g.get(prevRoom[i]).add(i);
        }
        int[] dp = new int[n];
        dfs(g, dp, 0);
        return dp[0];
    }
    private int dfs(List<List<Integer>> g, int[] dp, int u) {
        int mod = 1000000007;
        dp[u] = 1;
        for (int v : g.get(u)) {
            dp[u] = (int)((long)dp[u] * (dfs(g, dp, v) + 1) % mod);
        }
        return dp[u];
    }
}