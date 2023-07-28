class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, paths, path, 0);
        return paths;
    }
    
    public void dfs(int[][] graph, List<List<Integer>> paths, List<Integer> path, int node) {
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int n : graph[node]) {
            path.add(n);
            dfs(graph, paths, path, n);
            path.remove(path.size() - 1);
        }
    }
}