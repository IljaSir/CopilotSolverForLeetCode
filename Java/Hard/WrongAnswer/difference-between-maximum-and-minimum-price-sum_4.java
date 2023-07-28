class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        // build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // dfs
        long[] max = new long[n];
        long[] min = new long[n];
        dfs(graph, price, 0, -1, max, min);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, max[i] - min[i]);
        }
        return res;
    }
    private void dfs(List<List<Integer>> graph, int[] price, int root, int parent, long[] max, long[] min) {
        max[root] = min[root] = price[root];
        for (int child : graph.get(root)) {
            if (child == parent) {
                continue;
            }
            dfs(graph, price, child, root, max, min);
            max[root] = Math.max(max[root], max[child]);
            min[root] = Math.min(min[root], min[child]);
        }
    }
}