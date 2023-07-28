class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            graph[p[0]][p[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    graph[i][j] = graph[i][j] || graph[i][k] && graph[k][j];
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(graph[q[0]][q[1]]);
        }
        return res;
    }
}