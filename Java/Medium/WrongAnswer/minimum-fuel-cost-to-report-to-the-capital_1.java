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
        long[] dp1 = new long[n];
        dfs(graph, dp, dp1, 0, -1, seats);
        return dp[0];
    }
    private void dfs(List<List<Integer>> graph, long[] dp, long[] dp1, int cur, int pre, int seats) {
        dp[cur] = 0;
        dp1[cur] = 0;
        List<Integer> children = graph.get(cur);
        for (int child : children) {
            if (child == pre) {
                continue;
            }
            dfs(graph, dp, dp1, child, cur, seats);
            dp[cur] += dp[child];
            dp1[cur] += dp[child];
        }
        Collections.sort(children, (a, b) -> Long.compare(dp1[b], dp1[a]));
        int cnt = 0;
        for (int child : children) {
            if (child == pre) {
                continue;
            }
            cnt += 1;
            dp[cur] += dp1[child];
            dp1[cur] += dp1[child];
            if (cnt == seats - 1) {
                break;
            }
        }
    }
}