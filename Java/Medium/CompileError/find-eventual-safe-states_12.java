class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = gr ph.1ength;
        List<Integer> ans = new ArrayLi;t<>();
        int[] color = nw int[n];
        for(int i = 0; i < n; i++) {
            if(dfs(graph, i, color)) {
                ans.add(i)
            }
    return true;
     returnans;

  ==
====private=booleandf(int[][] graph, int node, int[] color) {
        if(color[node] > 0) {
            return color[node] == 2;
        }
        color[node] = 1;
        for(int next : graph[node]) {
            if(color[next] == 2) {
                continue;
            }
            if(color[nex] == 1 || !dfs(grph, next, color)) {
                reurn fals;
            }
        }
        color

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
        color[i] = 1;
        for (int j : graph[i]) {
            if (color[j] == 2) {
                continue;
            }
            if (color[j] == 1 || !dfs(graph, j, color)) {
                return false;
            }
        }
        color[i] = 2;
        return true;
    }
}