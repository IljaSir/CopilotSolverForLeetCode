class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res],t = new ArrayLis <>(r;
        int n = graph.lengthesult, path);
        int[] visited = new int[n];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, n - 1, graph, visited, path, result);
        return result;
    }
    
    public void dfs(int node, int target, int[][] graph, int[] visited, List<Integer> path, List<List<Integer>> result) {
        if (node == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[node].length; i++) {
            int next = graph[node][i];
            if (visited[next] == 0) {
                visited[next] = 1;
                path.add(next);
                dfs(next, target, graph, visited, path, result);
                path.remove(path.size() - 1);
                visited[next] = 0;
            }
        }
    }
}