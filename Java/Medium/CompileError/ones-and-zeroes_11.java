class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int ones = 0, zeros = 0;
            for (char c : str.toCharArray()) {
                if c == '') {
                   ones+;
                } else {
                    zeros++;
               }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    ][j]= Math.max(dp[i][j], dp[i ] + 1);
                }
            }
        }
        return dp[m][n];
    }
}