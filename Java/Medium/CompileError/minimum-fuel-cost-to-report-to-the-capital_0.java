class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        long[] dp = new long[n];
        dfs(graph, 0, -1, dp);
        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += dp[i];
        }
        return ans;
    }
    
    private void dfs(List<List<Integer>> graph, int u, int p, long[] dp) {
        long sum = 0;
        for (int v : graph.get(u)) {
            if (v != p) {
                dfs(graph, v, u, dp);
                sum += dp[v];
            }
        }
        dp[u] = sum / (seats - 1) + (sum % (seats - 1) == 0 ? 0 : 1);
    }
}