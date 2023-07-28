class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n + 1];
        return dfs(graph, visited, 1, target, t);
    }

    private double dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int node, int target, int t) {
        if (t < 0) {
            return 0;
        }
        if (node == target) {
            return t == 0 || graph.get(node).size() == 1 ? 1 : 0;
        }
        visited[node] = true;
        double res = 0;
        int count = 0;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count++;
            }
        }
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                res += dfs(graph, visited, next, target, t - 1) / count;
            }
        }
        visited[node] = false;
        return res;
    }
}