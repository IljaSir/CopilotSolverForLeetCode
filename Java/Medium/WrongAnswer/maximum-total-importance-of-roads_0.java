class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
            graph.computeIfAbsent(road[1], k -> new ArrayList<>()).add(road[0]);
        }
        long[] values = new long[n];
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited, values);
        return Arrays.stream(values).sum();
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited, long[] values) {
        visited[node] = true;
        values[node] = node + 1;
        List<Integer> adj = graph.get(node);
        if (adj == null) {
            return;
        }
        for (int next : adj) {
            if (!visited[next]) {
                dfs(graph, next, visited, values);
                values[node] += values[next];
            }
        }
    }
}