class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        int m = students.length;
        int n = students[0].length;
        int[][] comp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        comp[i][j]++;
                    }
                }
            }
        }
        int[] dp = new int[1 << m];
        for (int i = 1; i < 1 << m; i++) {
            int c = Integer.bitCount(i) - 1;
            int p = i ^ (1 << c);
            for (int j = 0; j < m; j++) {
                if ((p & (1 << j)) > 0) {
                    dp[i] = Math.max(dp[i], dp[p] + comp[j][c]);
                }
            }
        }
        return dp[(1 << m) - 1];
    }
}