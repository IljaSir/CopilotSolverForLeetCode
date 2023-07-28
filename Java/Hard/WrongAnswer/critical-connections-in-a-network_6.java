class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection: connections) {
            int a = connection.get(0), b = connection.get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, 0, rank, res);
        return res;
    }
    private int dfs(List<List<Integer>> graph, int node, int depth, int[] rank, List<List<Integer>> res) {
        if (rank[node] >= 0) {
            return rank[node];
        }
        rank[node] = depth;
        int minDepth = depth;
        for (int neighbor: graph.get(node)) {
            if (rank[neighbor] == depth - 1) {
                continue;
            }
            int neighborDepth = dfs(graph, neighbor, depth + 1, rank, res);
            if (neighborDepth <= depth) {
                res.add(Arrays.asList(node, neighbor));
            }
            minDepth = Math.min(minDepth, neighborDepth);
        }
        return minDepth;
    }
}