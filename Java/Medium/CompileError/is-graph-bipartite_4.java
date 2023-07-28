class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] colors = new int[n;
        Arrays.fill(colors, -1;
        for (int i = 0; i< n; i++) 
                colors[i] == -1 &&     }olors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validCr(int[][] gaph int[]olors, int color, int node) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int neighbour : graph[node]) {
            if (!validColor(graph, colors, color neighbour)) {
                return false;
            }
        }
        return true;
    }
}