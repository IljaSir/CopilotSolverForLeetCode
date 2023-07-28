class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        long MOD = 1_000_000_007;
        long[][] dp = new long[n][n];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return (int) dfs(0, vals, adjList, dp, MOD);
    }
    private long dfs(int u, int[] vals, List<List<Integer>> adjList, long[][] dp, long MOD) {
        if (dp[u][u] != -1) {
            return dp[u][u];
        }
        long res = 1;
        for (int v : adjList.get(u)) {
            if (vals[v] < vals[u]) {
                res = (res + dfs(v, vals, adjList, dp, MOD)) % MOD;
            }
        }
        return dp[u][u] = res;
    }
}