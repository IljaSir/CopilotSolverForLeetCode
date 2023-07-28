class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        int n = students.length;
        int m = students[0].length;
        int[][] compat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    compat[i][j] += students[i][k] == mentors[j][k] ? 1 : 0;
                }
            }
        }
        int[] dp = new int[1 << n];
        for (int i = 0; i < n; i++) {
            dp[1 << i] = compat[0][i];
        }
        for (int i = 1; i < (1 << n); i++) {
            int c = Integer.bitCount(i);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    dp[i | (1 << j)] = Math.max(dp[i | (1 << j)], dp[i] + compat[c][j]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}