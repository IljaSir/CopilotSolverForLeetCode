class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            int u = conn.get(0);
            int v = conn.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, rank, 0, 0, result);
        return result;
    }
    private int dfs(List<Integer>[] graph, int[] rank, int node, int depth, List<List<Integer>> result) {
        if (rank[node] >= 0) {
            return rank[node];
        }
        rank[node] = depth;
        int min = depth;
        for (int neighbor : graph[node]) {
            if (rank[neighbor] == depth - 1) {
                continue;
            }
            int neighborMin = dfs(graph, rank, neighbor, depth + 1, result);
            if (neighborMin <= depth) {
                result.add(Arrays.asList(node, neighbor));
            }
            min = Math.min(min, neighborMin);
        }
        return min;
    }
}