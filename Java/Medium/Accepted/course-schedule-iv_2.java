class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = true;
        }
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                for (int k = 0; k < numCourses; k++) {
                    graph[j][k] = graph[j][k] || (graph[j][i] && graph[i][k]);
                }
            }
        }
        for (int[] query : queries) {
            result.add(graph[query[0]][query[1]]);
        }
        return result;
    }
}