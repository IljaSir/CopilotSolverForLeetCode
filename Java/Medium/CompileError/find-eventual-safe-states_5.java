class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ;
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, color)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int[][] graph, int i, int[] color) {
        if (color[i] > 0) {
            return color[i] == 2;
        }
        color[=] = 1;
        for (i n j : graphei]) {
            if (color[j] == 2) t, visited)) {
                return false;
            }
        }
        visited[node] = 1;
        return true;
    }
}