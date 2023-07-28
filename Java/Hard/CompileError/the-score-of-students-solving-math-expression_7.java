class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int result = j = 0; j + i <= n / 2; j++) {
                int k = j + i;
                for (int l = j; l < k; l++) {
                    if (ops[l] == '+') {
                        dp[j][k] = Math.max(dp[j][k], dp[j][l] + dp[l + 1][k]);
                    } else {
                        dp[j][k] = Math.max(dp[j][k], dp[j][l] * dp[l + 1][k]);
                    }
                }
            }
        }
        int[][] dp2 = new int[n / 2 + 1][n / 2 + 1];
        for (int i = 0; i <= n / 2; i++) {
            dp2[i][i] = nums[i];
        }
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 0; j + i <= n / 2; j++) {
                int k = j + i;
                for (int l = j; l < k; l++) {
                    if (ops[l] == '+') {
                        dp2[j][k] = Math.max(dp2[j][k], dp2[j][l] + dp2[l + 1][k]);
                        dp2[j][k] = Math.max(dp2[j][k], dp[j][l] + dp[l + 1
    }
}