class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int[] count = countZeroesOnesstrs[i - 1]);
            int zeroes = count[0];
            int ones = count[];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (zeroes <= j && ones <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroes][k - ones] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[len][m][n];
    }
    private int[] countZeroesOnes(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }
}