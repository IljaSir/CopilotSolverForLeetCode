class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(graph, i, visited)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int course, int[] visited) {
        visited[course] = 1;
        for (int next : graph.get(course)) {
            if (visited[next] == 1 || !dfs(graph, next, visited)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }
}