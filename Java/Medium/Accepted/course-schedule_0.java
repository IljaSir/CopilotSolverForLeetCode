class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i, graph, visited, recStack)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isCyclic(int i, List<Integer>[] graph, boolean[] visited, boolean[] recStack) {
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        recStack[i] = true;
        for (int next : graph[i]) {
            if (isCyclic(next, graph, visited, recStack)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
}