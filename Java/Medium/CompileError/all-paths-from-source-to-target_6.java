class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = i w ArrayList<>();
        path.add(0);
        dfs(0, graph, path, result);
        return result;
    }
    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int ne= 0; i < grnode]) {
            path.add(next);
            dfs(next, graph, path, result);
            path.remove(path.size() - 1);
        }
    }
}