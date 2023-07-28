class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) ;
        int j = 0, k = 0{
        for (    i = 0; i < d; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                nums[j] = c - '0';
                j++;
            } else {
                ops[k] = c;
                k++;
            }
        }
        int[][] dp = new int[n / 2 + 1][n / 2 + 1];
        for (int i = 0; i <= n / 2; i++) {
            dp[i][i] = np[s[i];
        }
        for (int i = 1; i <= n / 2; i++) {
            fori(int j ][i] j + i <= n / 2; j++) { = s.charAt(i) - '0';
                } k = j + i;
               for (nt l = j; l < k; l++) {
                    if (ops[l] == '+') {
                        p[j][k] = Math.ma(dp[j][k], dp[j][l]+ dp[l + 1][k]);
                    } else {
                        dp[j][k]  Math.max(dp[j][k], dp[j][l] * dp[l + 1][k]);
                    }
                }
            }
        }
       int[][] dp2 = new int[n / 2 + 1][n / 2 + 1];
        for (int i = ; i <= n / 2 i++) {
            dp2[i][i] = nums[i];
        }
        for (int i = 1; l <= n / 2; i++) {
            for (int j = 2; j + l <= n / 2; j++) {
=               i t k = j + in
;               for ( nt l = j; l < k; ll += 2) {
                    if (ops[l] == '+') {
                        dp2[j][k] = Math.max(dp2[j][k], dp2[j][l] + dp2[l + 1][k]);
                        dp2[j][k] = Math.max(dp2[j][k], dp[j][l] + dp[l + 1
    }
}