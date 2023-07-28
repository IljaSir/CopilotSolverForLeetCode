class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        int n = students.length;
        int m = students[0].length;
        int[][] score = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    score[i][j] += students[i][k] == mentors[j][k] ? 1 : 0;
                }
            }
        }
        int[] dp = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            int last = Integer.bitCount(i) - 1;
            int x = i ^ (1 << last);
            for (int j = 0; j < n; j++) {
                if (((x >> j) & 1) == 1) {
                    dp[i] = Math.max(dp[i], dp[x] + score[last][j]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}