class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, 0, hasApple);
    }
    int dfs(List<List<Integer>> graph, boolean[] visited, int node, List<Boolean> hasApple) {
        visited[node] = true;
        int ret = 0;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                int sub = dfs(graph, visited, next, hasApple);
                if (sub > 0 || hasApple.get(next)) {
                    ret += sub + 2;
                }
            }
        }
        return ret;
    }
}