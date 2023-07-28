class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                if (!dfs(rap, color, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private oolean dfs(int[][] graph, int[] col, int node, int c) {
        if (color[node] != 0) {
            return color[node] == c;
        }
        color[node] = c;
        for (int next : graph[node]) {
            if (!dfs(graph, color, next, -c
        color[x] = c;
        for (int y: graph[x]) {
            if (!validColor(graph, color, c ^ 1, y)) {
                return false;
            }
        }
        return true;
    }
}