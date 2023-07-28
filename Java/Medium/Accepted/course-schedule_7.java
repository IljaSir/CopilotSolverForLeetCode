class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Create a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        // Create visited array
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, int node) {
        if (visited[node] == 1) {
            return false;
        }
        if (visited[node] == 2) {
            return true;
        }
        visited[node] = 1;
        for (int next : graph.get(node)) {
            if (!dfs(graph, visited, next)) {
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }
}