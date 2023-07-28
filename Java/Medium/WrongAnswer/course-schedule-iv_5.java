class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        int[][] matrix = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            matrix[p[1]][p[0]] = 1;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (matrix[i][k] == 1 && matrix[k][j] == 1) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }
        for (int[] q : queries) {
            result.add(matrix[q[0]][q[1]] == 1);
        }
        return result;
    }
}