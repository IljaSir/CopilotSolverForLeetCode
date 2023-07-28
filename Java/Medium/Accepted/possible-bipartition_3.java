class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] dislike : dislikes) {
            graph.putIfAbsent(dislike[0], new HashSet<>());
            graph.putIfAbsent(dislike[1], new HashSet<>());
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        int[] groups = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (groups[i] == 0 && !dfs(graph, groups, i, 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, Set<Integer>> graph, int[] groups, int node, int group) {
        if (groups[node] != 0) {
            return groups[node] == group;
        }
        groups[node] = group;
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!dfs(graph, groups, neighbor, -group)) {
                    return false;
                }
            }
        }
        return true;
    }
}