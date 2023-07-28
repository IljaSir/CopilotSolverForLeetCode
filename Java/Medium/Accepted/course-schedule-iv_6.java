class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> ans = new ArrayList<>();
        if (prerequisites.length == 0) {
            for (int[] query : queries) {
                ans.add(false);
            }
            return ans;
        }
        int[][] graph = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = 1;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    graph[i][j] = graph[i][j] | (graph[i][k] & graph[k][j]);
                }
            }
        }
        for (int[] query : queries) {
            ans.add(graph[query[0]][query[1]] == 1);
        }
        return ans;
    }
}