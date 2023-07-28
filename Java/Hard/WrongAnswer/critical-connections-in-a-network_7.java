class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> res = new ArrayList<>();
        int[] rank = new int[n];
        int[] low = new int[n];
        Arrays.fill(rank, -1);
        Arrays.fill(low, -1);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : connections) {
            int a = edge.get(0);
            int b = edge.get(1);
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(graph, 0, 0, rank, low, res);
        return res;
    }
    private int dfs(Map<Integer, List<Integer>> graph, int prev, int cur, int[] rank, int[] low, List<List<Integer>> res) {
        if (rank[cur] != -1) {
            return rank[cur];
        }
        rank[cur] = low[cur] = prev + 1;
        for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
            if (next == prev) {
                continue;
            }
            rank[cur] = Math.min(rank[cur], dfs(graph, cur, next, rank, low, res));
        }
        if (rank[cur] > low[cur]) {
            res.add(Arrays.asList(prev, cur));
        }
        return rank[cur];
    }
}