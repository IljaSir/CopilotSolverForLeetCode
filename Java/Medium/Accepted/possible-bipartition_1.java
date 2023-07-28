class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(List<Integer>[] graph, int[] colors, int node, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (!dfs(graph, colors, neighbor, -color)) {
                return false;
            }
        }
        return true;
    }
}