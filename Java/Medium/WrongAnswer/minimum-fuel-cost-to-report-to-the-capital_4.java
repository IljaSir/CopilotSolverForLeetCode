class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int n = roads.length + 1;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        long[] fuel = new long[n];
        Arrays.fill(fuel, Long.MAX_VALUE);
        fuel[0] = 0;
        dfs(graph, fuel, 0, -1);
        Arrays.sort(fuel);
        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += fuel[i];
        }
        return ans;
    }
    private void dfs(List<Integer>[] graph, long[] fuel, int u, int p) {
        int cnt = 0;
        for (int v : graph[u]) {
            if (v != p) {
                dfs(graph, fuel, v, u);
                cnt++;
            }
        }
        if (p != -1) {
            fuel[u] = fuel[p] + Math.max(0, cnt - 1);
        }
    }
}