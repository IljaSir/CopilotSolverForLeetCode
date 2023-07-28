class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !validColor(graph, color, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] color, int c, int node) {
        if (color[node] != 0) {
            return color[node] == c;
        }
        color[node] = c;
        for (int neighbor : graph[node]) {
            if (!validColor(graph, color, -c, neighbor)) {
                return false;
            }
        }
        return true;
    }
}