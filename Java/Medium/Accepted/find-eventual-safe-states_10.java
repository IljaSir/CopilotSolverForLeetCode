class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> result = new ArrayList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, color, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int[] color, int i) {
        if (color[i] > 0) {
            return color[i] == 2;
        }
        color[i] = 1;
        for (int j : graph[i]) {
            if (color[j] == 2) {
                continue;
            }
            if (color[j] == 1 || !dfs(graph, color, j)) {
                return false;
            }
        }
        color[i] = 2;
        return true;
    }
}