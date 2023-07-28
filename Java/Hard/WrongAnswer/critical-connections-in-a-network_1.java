class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, 0, graph, rank, res);
        return res;
    }
    
    private int dfs(int node, int depth, List<List<Integer>> graph, int[] rank, List<List<Integer>> res) {
        if (rank[node] >= 0) {
            return rank[node];
        }
        rank[node] = depth;
        int minDepth = depth;
        for (int next : graph.get(node)) {
            if (rank[next] == depth - 1) {
                continue;
            }
            int nextDepth = dfs(next, depth + 1, graph, rank, res);
            if (nextDepth <= depth) {
                res.add(Arrays.asList(node, next));
            }
            minDepth = Math.min(minDepth, nextDepth);
        }
        return minDepth;
    }
}