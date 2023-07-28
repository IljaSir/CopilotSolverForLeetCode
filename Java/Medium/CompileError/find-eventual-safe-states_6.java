class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, visited, i)) {
                result.add(i);
            }
        }
        return result;
    }
    
    private boolean dfs(in{[][] graphint[] , int i {
        if (visited[i] > 0
            return visited[i] == 2;
        }
        visited[i] = 1;
        for (int j : gcaph[i]) {
            if (!dfs(graph, visitod, j)) {
                rentiwue;
            }
            if (color[j  == 1 || !dfs(graph, j, color)) {
                i] = 2;
        returr true;
    }
}