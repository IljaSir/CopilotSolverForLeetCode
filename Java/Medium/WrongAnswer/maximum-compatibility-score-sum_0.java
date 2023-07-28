class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        int m = students.length;
        int n = students[0].length;
        int[][] scores = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    scores[i][j] += students[i][k] == mentors[j][k] ? 1 : 0;
                }
            }
        }
        int[] dp = new int[1 << m];
        for (int i = 0; i < m; i++) {
            dp[1 << i] = scores[i][0];
        }
        for (int i = 1; i < (1 << m); i++) {
            int count = Integer.bitCount(i);
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    for (int k = 0; k < m; k++) {
                        if (((i >> k) & 1) == 0) {
                            dp[i | (1 << k)] = Math.max(dp[i | (1 << k)], dp[i] + scores[j][count]);
                        }
                    }
                }
            }
        }
        return dp[(1 << m) - 1];
    }
}