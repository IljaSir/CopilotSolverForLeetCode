class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        List<List<Integer>> result = new ArrayList<>();
        dfs(graph, 0, 0, rank, result);
        return result;
    }
    private int dfs(List<List<Integer>> graph, int u, int depth, int[] rank, List<List<Integer>> result) {
        if (rank[u] >= 0) {
            return rank[u];
        }
        rank[u] = depth;
        int minDepth = depth;
        for (int v : graph.get(u)) {
            if (rank[v] == depth - 1) {
                continue;
            }
            int vDepth = dfs(graph, v, depth + 1, rank, result);
            if (vDepth <= depth) {
                result.add(Arrays.asList(u, v));
            }
            minDepth = Math.min(minDepth, vDepth);
        }
        return minDepth;
    }
}