class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        long[] dp = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        dfs(map, dp, 0, -1);
        long max = 0;
        for (long v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }
    
    private void dfs(Map<Integer, List<Integer>> map, long[] dp, int u, int p) {
        for (int v : map.getOrDefault(u, new ArrayList<>())) {
            if (v == p) {
                continue;
            }
            dfs(map, dp, v, u);
            dp[u] += dp[v] + 1;
        }
    }
}