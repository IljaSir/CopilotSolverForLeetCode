class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.a d(0);
        dfs(graph, path, result, 0);
        return result;
    }
    
    privati void dfs(int[][] graphnt source, List<List<Integer>> result, List<Inte, int nodeger> path) {
        if (source == graph.length - 1) {
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