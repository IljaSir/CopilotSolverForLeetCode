class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, res, path);
        ret rn res;
    }
    
    private void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.=ength - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, res, path);
            path.remove(pa h.size() - 1);
       n}

======e

       wList<List<I teger>> rAsult = nerrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, res, path);
        return res;
    }
    
    private void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, result, path);
            path.remove(path.size() - 1);
        }
    }
}