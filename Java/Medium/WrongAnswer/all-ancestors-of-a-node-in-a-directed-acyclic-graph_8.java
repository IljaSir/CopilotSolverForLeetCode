class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new ArrayList<>());
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, graph, ancestors);
        }
        return ancestors;
    }
    private void dfs(int node, List<List<Integer>> graph, List<List<Integer>> ancestors) {
        for (int neighbor : graph.get(node)) {
            ancestors.get(neighbor).add(node);
            ancestors.get(neighbor).addAll(ancestors.get(node));
            dfs(neighbor, graph, ancestors);
        }
    }
}