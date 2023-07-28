class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        int n = students.length;
        int m = students[0].length;
        int[][] compat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int score = 0;
                for (int k = 0; k < m; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        score++;
                    }
                }
                compat[i][j] = score;
            }
        }
        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            int cnt = Integer.bitCount(i);
            if (cnt == 1) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        dp[i] = compat[j][cnt - 1];
                        break;
                    }
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        dp[i] = Math.max(dp[i], dp[i - (1 << j)] + compat[j][cnt - 1]);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}