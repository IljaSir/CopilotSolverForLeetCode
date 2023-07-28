class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] r : roads) {
            graph.computeIfAbsent(r[0], x -> new ArrayList<>()).add(r[1]);
            graph.computeIfAbsent(r[1], x -> new ArrayList<>()).add(r[0]);
        }
        long[] max = {0};
        boolean[] visited = new boolean[n];
        dfs(0, graph, visited, 0, max);
        return max[0];
    }
    
    private void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited, long score, long[] max) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        max[0] = Math.max(max[0], score);
        for (int next : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(next, graph, visited, score + next + 1, max);
        }
        visited[node] = false;
    }
}