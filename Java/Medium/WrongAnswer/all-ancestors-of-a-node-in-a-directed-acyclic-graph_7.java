class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, graph, ans, new HashSet<>());
        }
        return ans;
    }
    private void dfs(int i, Map<Integer, List<Integer>> graph, List<List<Integer>> ans, Set<Integer> visited) {
        if (visited.contains(i)) {
            return;
        }
        visited.add(i);
        for (int j : graph.getOrDefault(i, new ArrayList<>())) {
            ans.get(j).add(i);
            dfs(j, graph, ans, visited);
        }
    }
}