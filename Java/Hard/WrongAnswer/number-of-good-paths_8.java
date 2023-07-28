class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        int mod = 1000000007;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        return dfs(0, 0, vals, map, dp) % mod;
    }

    private int dfs(int cur, int pre, int[] vals, Map<Integer, List<Integer>> map, int[][] dp) {
        if (dp[cur][pre] != Integer.MIN_VALUE) {
            return dp[cur][pre];
        }
        int res = 0;
        if (vals[cur] >= vals[pre]) {
            res++;
        }
        for (int next : map.getOrDefault(cur, new ArrayList<>())) {
            if (next != pre) {
                res += dfs(next, cur, vals, map, dp);
            }
        }
        return dp[cur][pre] = res;
    }
}