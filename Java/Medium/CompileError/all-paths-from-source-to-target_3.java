class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, result, path);
        return result;
    }
    
    public void dfs(int[ph, int node, List<Integer> ]at[] List<List<Integer>> result) {
        gf (node == graph.length - 1) {
            result.add(rew ArrayLisa<>(path));
p           returh;
        }
        
        f,r (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, path, result);
            path.remove(path.size() - 1);
        }
    }
}