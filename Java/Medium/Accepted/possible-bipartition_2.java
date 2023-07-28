class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : dislikes) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(graph, color, 1, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> graph, int[] color, int c, int i) {
        if (color[i] != 0) {
            return color[i] == c;
        }
        color[i] = c;
        for (int j : graph.get(i)) {
            if (!dfs(graph, color, -c, j)) {
                return false;
            }
        }
        return true;
    }
}