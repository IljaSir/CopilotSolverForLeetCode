class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        long[] res = dfs(graph, price, 0, -1);
        return res[0];
    }

    private long[] dfs(Map<Integer, List<Integer>> graph, int[] price, int root, int parent) {
        long[] res = new long[2];
        res[0] = price[root];
        res[1] = price[root];
        for (int child : graph.getOrDefault(root, new ArrayList<>())) {
            if (child == parent) {
                continue;
            }
            long[] childRes = dfs(graph, price, child, root);
            res[0] = Math.max(res[0], childRes[0]);
            res[1] = Math.min(res[1], childRes[1]);
        }
        res[0] -= res[1];
        return res;
    }
}