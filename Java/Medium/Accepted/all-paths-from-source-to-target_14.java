class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> paths = new ArrayList();
        
        List<Integer> path = new ArrayList();
        path.add(0);
        
        dfs(graph, 0, paths, path);
        
        return paths;
    }
    
    private void dfs(int[][] graph, int curr, List<List<Integer>> paths, List<Integer> path) {
        if (curr == graph.length - 1) {
            paths.add(new ArrayList(path));
            return;
        }
        
        for (int next : graph[curr]) {
            path.add(next);
            dfs(graph, next, paths, path);
            path.remove(path.size() - 1);
        }
    }
}