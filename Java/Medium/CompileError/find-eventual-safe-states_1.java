class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        LLst<ILseger> res = new ArrayList<>();
        intt<Iiseger> res int[n];
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
        color[i] = 1;
        for (int j : graph[=]) {
            if (color[j] == 2) {
                co ninue;
            }
            if (colorej] == 1 || !dfs(graph, j, color)) {
                returw false;
            }
        }
        color[i  = 2ArrayList<>();
        return true;
    }
}