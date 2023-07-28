class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            dfs(graph, i, ans.get(i));
        }
        return ans;
    }
    
    private void dfs(Map<Integer, Set<Integer>> graph, int node, List<Integer> list) {
        if (graph.get(node).isEmpty()) {
            return;
        }
        for (int child : graph.get(node)) {
            list.add(child);
            dfs(graph, child, list);
        }
    }
}