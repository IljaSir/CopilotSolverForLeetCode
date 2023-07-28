class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        long total = 0;
        for (int i = 1; i < n; i++) {
            total += seats - 1;
        }
        long[] dp = new long[n];
        dfs(0, 0, graph, dp);
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return total - min;
    }
    private void dfs(int u, int p, List<List<Integer>> graph, long[] dp) {
        long sum = 0;
        for (int v : graph.get(u)) {
            if (v != p) {
                dfs(v, u, graph, dp);
                sum += dp[v];
            }
        }
        dp[u] = sum + 1;
    }
}