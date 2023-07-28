class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        int m = students.length;
        int n = students[0].length;
        int[] score = new int[1];
        boolean[] used = new boolean[m];
        dfs(students, mentors, m, n, 0, 0, used, score);
        return score[0];
    }

    private void dfs(int[][] students, int[][] mentors, int m, int n, int s, int index, boolean[] used, int[] score) {
        if (index == m) {
            score[0] = Math.max(score[0], s);
            return;
        }
        for (int i = 0; i < m; i++) {
            if (!used[i]) {
                int tmp = 0;
                for (int j = 0; j < n; j++) {
                    tmp += students[index][j] == mentors[i][j] ? 1 : 0;
                }
                used[i] = true;
                dfs(students, mentors, m, n, s + tmp, index + 1, used, score);
                used[i] = false;
            }
        }
    }
}