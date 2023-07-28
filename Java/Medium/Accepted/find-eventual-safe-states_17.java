class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> result = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return result;
        }
        int[] state = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph, state)) {
                result.add(i);
            }
        }
        return result;
    }
    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] == 1) {
            return false;
        }
        if (state[node] == 2) {
            return true;
        }
        state[node] = 1;
        for (int i = 0; i < graph[node].length; i++) {
            if (!dfs(graph[node][i], graph, state)) {
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}