class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).put(edge[1], 1);
            graph.get(edge[1]).put(edge[0], 1);
        }
        long[] res = new long[1];
        dfs(graph, 0, -1, price, new boolean[n], res);
        return res[0];
    }
    private void dfs(Map<Integer, Map<Integer, Integer>> graph, int cur, int parent, int[] price, boolean[] visited, long[] res) {
        visited[cur] = true;
        long sum = 0;
        long max = 0;
        long min = Long.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry: graph.get(cur).entrySet()) {
            if (entry.getKey() == parent || visited[entry.getKey()]) {
                continue;
            }
            dfs(graph, entry.getKey(), cur, price, visited, res);
            sum += entry.getValue();
            max = Math.max(max, entry.getValue());
            min = Math.min(min, entry.getValue());
        }
        if (sum > 0) {
            res[0] = Math.max(res[0], max - min);
        }
        graph.get(cur).put(parent, (int)sum + price[cur]);
    }
}