class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        dfs(graph, 0, result, path);
        return result;
    }
    public void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int next: graph[node]) {
            path.add(next);
            dfs(graph, next, result, path);
            path.remove(path.size() - 1);
        }
    }
}