class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        // Check for cycle
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, visited, path)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, Set<Integer> visited, Set<Integer> path) {
        if (path.contains(course)) {
            return true;
        }
        if (visited.contains(course)) {
            return false;
        }
        visited.add(course);
        path.add(course);
        for (int nextCourse : graph.get(course)) {
            if (hasCycle(graph, nextCourse, visited, path)) {
                return true;
            }
        }
        path.remove(course);
        return false;
    }
}