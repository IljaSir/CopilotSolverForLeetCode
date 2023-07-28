class Solution {
    public int minReorder(int n, int[][] connections) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(-from);
        }
        int[] visited = new int[n];
        return dfs(graph, visited, 0);
    }

    private int dfs(Map<Integer, List<Integer>> graph, int[] visited, int node) {
        visited[node] = 1;
        int count = 0;
        for (int next : graph.getOrDefault(node, new ArrayList<>())) {
            if (visited[Math.abs(next)] == 1) {
                continue;
            }
            if (next > 0) {
                count++;
            }
            count += dfs(graph, visited, Math.abs(next));
        }
        return count;
    }
}