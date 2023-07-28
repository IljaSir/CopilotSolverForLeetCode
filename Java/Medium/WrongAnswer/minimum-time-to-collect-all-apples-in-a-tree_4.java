class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(adj, visited, 0, hasApple);
    }
    private int dfs(List<List<Integer>> adj, boolean[] visited, int node, List<Boolean> hasApple) {
        visited[node] = true;
        int res = 0;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                res += dfs(adj, visited, nei, hasApple);
            }
        }
        if (res > 0 || hasApple.get(node)) {
            return res + 2;
        }
        return 0;
    }
}