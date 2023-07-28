class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        
        int n = vals.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(0, -1, vals, graph, new int[n][n]);
    }
    
    private int dfs(int node, int parent, int[] vals, List<List<Integer>> graph, int[][] memo) {
        if (memo[node][parent + 1] > 0) {
            return memo[node][parent + 1];
        }
        int count = 1;
        for (int next : graph.get(node)) {
            if (next != parent && vals[next] >= vals[node]) {
                count += dfs(next, node, vals, graph, memo);
            }
        }
        memo[node][parent + 1] = count;
        return count;
    }
}