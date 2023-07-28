class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        int n = amount.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] dp = new int[n];
        int[] next = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        dfs(adjList, 0, visited, parent);
        for (int i = n - 1; i > 0; i--) {
            int u = i;
            int v = parent[i];
            next[u] = v;
            next[v] = u;
        }
        for (int i = 0; i < n; i++) {
            dp[i] = amount[i];
        }
        for (int i = n - 1; i > 0; i--) {
            int u = i;
            int v = next[i];
            if (u > bob) {
                dp[v] += dp[u] / 2;
            } else {
                dp[v] += dp[u];
            }
        }
        return Math.max(dp[0], dp[bob]);
    }
    private void dfs(List<List<Integer>> adjList, int u, boolean[] visited, int[] parent) {
        visited[u] = true;
        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                dfs(adjList, v, visited, parent);
            }
        }
    }
}