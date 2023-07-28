class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        int[][] graph = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dfs(i, i, graph, 0, new boolean[n]));
        }
        return res == n + 1 ? -1 : res;
    }
    private int dfs(int start, int cur, int[][] graph, int len, boolean[] visited) {
        if (cur == start && len > 1) {
            return len;
        }
        visited[cur] = true;
        int res = graph.length + 1;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[cur][i] == 1) {
                res = Math.min(res, dfs(start, i, graph, len + 1, visited));
            }
        }
        visited[cur] = false;
        return res;
    }
}