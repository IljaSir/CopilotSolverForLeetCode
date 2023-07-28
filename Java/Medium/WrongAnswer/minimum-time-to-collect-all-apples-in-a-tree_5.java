class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return dfs(tree, 0, new HashSet<>(), hasApple);
    }
    
    private int dfs(Map<Integer, Set<Integer>> tree, int node, Set<Integer> visited, List<Boolean> hasApple) {
        int time = 0;
        visited.add(node);
        for (int child : tree.get(node)) {
            if (!visited.contains(child)) {
                time += dfs(tree, child, visited, hasApple);
            }
        }
        if (time > 0 || hasApple.get(node)) {
            time += 2;
        }
        return time;
    }
}