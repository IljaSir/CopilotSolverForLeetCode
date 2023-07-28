class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        int[][] graph = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            graph[p[0]][p[1]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                for (int k = 0; k < numCourses; k++) {
                    if (graph[j][i] == 1 && graph[i][k] == 1) {
                        graph[j][k] = 1;
                    }
                }
            }
        }
        for (int[] q : queries) {
            result.add(graph[q[0]][q[1]] == 1);
        }
        return result;
    }
}