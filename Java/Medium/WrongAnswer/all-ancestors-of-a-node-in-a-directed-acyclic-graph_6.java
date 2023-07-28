class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(graph, i, ans);
        }
        return ans;
    }
    private void dfs(Map<Integer, List<Integer>> graph, int node, List<List<Integer>> ans) {
        if (graph.containsKey(node)) {
            for (int child : graph.get(node)) {
                ans.get(child).add(node);
                dfs(graph, child, ans);
            }
        }
    }
}