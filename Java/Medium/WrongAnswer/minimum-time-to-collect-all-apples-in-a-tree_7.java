class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> l1 = graph.getOrDefault(edge[0], new ArrayList<>());
            l1.add(edge[1]);
            graph.put(edge[0], l1);
            List<Integer> l2 = graph.getOrDefault(edge[1], new ArrayList<>());
            l2.add(edge[0]);
            graph.put(edge[1], l2);
        }
        return dfs(0, -1, graph, hasApple);
    }
    
    private int dfs(int node, int parent, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {
        int time = 0;
        for (int child : graph.get(node)) {
            if (child != parent) {
                time += dfs(child, node, graph, hasApple);
            }
        }
        if (time == 0 && !hasApple.get(node)) {
            return 0;
        }
        return time + 2;
    }
}