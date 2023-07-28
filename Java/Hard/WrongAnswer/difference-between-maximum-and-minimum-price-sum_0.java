class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] parent = new int[n];
        int[] depth = new int[n];
        dfs(graph, parent, depth, 0, 0);
        long[] sum = new long[n];
        long[] max = new long[n];
        long[] min = new long[n];
        for (int i = 0; i < n; i++) {
            sum[i] = price[i];
            max[i] = price[i];
            min[i] = price[i];
        }
        for (int i = n - 1; i > 0; i--) {
            int p = parent[i];
            sum[p] += sum[i];
            max[p] = Math.max(max[p], max[i]);
            min[p] = Math.min(min[p], min[i]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, max[i] - min[i]);
        }
        return ans;
    }
    private void dfs(List<List<Integer>> graph, int[] parent, int[] depth, int u, int p) {
        parent[u] = p;
        depth[u] = depth[p] + 1;
        for (int v : graph.get(u)) {
            if (v != p) {
                dfs(graph, parent, depth, v, u);
            }
        }
    }
}