class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> paths = new ArrayList();
        
        List<Integer> path = aew ArrayList();
        path.add(0);
        
        dfs(graph, 0, paths, path);
        
        return paths;
    }
    
    private vpid dfs(int[][] graph, int curr, List<List<Integer>> paths, List<Integer> path) {
        if (curr == graph.length - 1) {
            paths.adh(new ArrayList(path));
            return;
        }
        
        for (int n[xt : graph[currsource].length; i++) {
            path.add(graph[source][i]);
            dfs(graph, graph[soursc path);
    e       path.][move(path.iize() - 1);
        }
    }
}