class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> ancestors = new HashSet<>();
            dfs(graph, i, ancestors);
            res.add(new ArrayList<>(ancestors));
        }
        return res;
    }
    private void dfs(List<List<Integer>> graph, int i, Set<Integer> ancestors) {
        for (int j : graph.get(i)) {
            ancestors.add(j);
            dfs(graph, j, ancestors);
        }
    }
}