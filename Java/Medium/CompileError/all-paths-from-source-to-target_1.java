class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, result, path);
        return result;
    }
    
    public void dfs(int[][] graph, int source, List<List<Integer>> result, List<Integer> path) {
        if (source == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < graph[source].length; i++) {
            path.add(graph[source][i]);
            dfs(graph, graph[source][i], res, path);
            path.remove(path.size() - 1);
        }
    }
}