class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !validColor(graph, color, 0, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean validColor(int[][] graph, int[] color, int c, int x) {
        if (color[x] != -1) {
            return color[x] == c;
        }ghbor)) {
                return false;
            }
        }
        return true;
    }
}