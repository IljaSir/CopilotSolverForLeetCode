class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        long[] min = new long[n], max = new long[n], sum = new long[n];
        boolean[] visited = new boolean[n];
        dfs(0, g, price, min, max, sum, visited);
        long res = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, max[i] - min[i]);
        }
        return res;
    }
    private void dfs(int u, Map<Integer, List<Integer>> g, int[] price, long[] min, long[] max, long[] sum, boolean[] visited) {
        visited[u] = true;
        min[u] = max[u] = sum[u] = price[u];
        for (int v : g.getOrDefault(u, Collections.emptyList())) {
            if (visited[v]) continue;
            dfs(v, g, price, min, max, sum, visited);
            min[u] = Math.min(min[u], min[v]);
            max[u] = Math.max(max[u], max[v]);
            sum[u] += sum[v];
        }
        min[u] = Math.min(min[u], sum[u] - max[u]);
        max[u] = Math.max(max[u], sum[u] - min[u]);
    }
}