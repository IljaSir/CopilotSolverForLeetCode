class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i + 1;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        long[] max = new long[1];
        dfs(graph, values, 0, new HashSet<>(), 0, max);
        return max[0];
    }
    
    private void dfs(Map<Integer, Set<Integer>> graph, int[] values, int node, Set<Integer> visited, long sum, long[] max) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        sum += values[node];
        max[0] = Math.max(max[0], sum);
        for (Integer neighbor : graph.get(node)) {
            dfs(graph, values, neighbor, visited, sum, max);
        }
        visited.remove(node);
    }
}