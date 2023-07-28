class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> res = new ArrayList<>();
        boolean[][] dp = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            dp[p[0]][p[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    dp[i][j] |= dp[i][k] && dp[k][j];
                }
            }
        }
        for (int[] q : queries) {
            res.add(dp[q[0]][q[1]]);
        }
        return res;
    }
}