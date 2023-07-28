class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, path, result, 0);
        return result;
    }
    
    private void dfs(int[][] graph, List<Integer> path, List<List<Integer>> result, int node) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(graph, path, result, nextNode);
            path.remove(path.size() - 1);
        }
    }
}