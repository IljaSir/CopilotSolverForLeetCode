class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] colors = new int[n];
        for ys.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !validColor(graph, color, 0, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validColor(int[][] graph, int[] color, int c, int i) {
        if (color[i] != -1) {
            return color[i] == c;
        }
        color[i] = c;
        for (int j : graph[i]) {
            if (!validColor(graph, color, 1 - c, j)) {
                return false;
            }
        }
        return true;
    }
}
    }
}