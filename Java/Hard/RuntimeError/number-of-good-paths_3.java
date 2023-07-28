class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int MOD = 1000000007;
        int n = vals.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + dfs(graph, vals, dp, i, i)) % MOD;
        }
        return res;
    }
    
    private int dfs(List<Integer>[] graph, int[] vals, int[][] dp, int start, int cur) {
        if (dp[start][cur] != -1) return dp[start][cur];
        if (vals[cur] < vals[start]) {
            dp[start][cur] = 0;
            return 0;
        }
        int res = 0;
        for (int next : graph[cur]) {
            if (next == start) {
                res = (res + 1) % 1000000007;
            } else {
                res = (res + dfs(graph, vals, dp, start, next)) % 1000000007;
            }
        }
        dp[start][cur] = res;
        return res;
    }
}