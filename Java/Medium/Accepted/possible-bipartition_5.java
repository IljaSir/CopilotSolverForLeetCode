class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<Integer>[] graph, int[] colors, int node, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int nei : graph[node]) {
            if (!dfs(graph, colors, nei, -color)) {
                return false;
            }
        }
        return true;
    }
}