class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int n = destination[0];
        int m = destination[1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        int p = n;
        int q = m;
        StringBuilder sb = new StringBuilder();
        while (p > 0 || q > 0) {
            if (p > 0 && dp[p - 1][q] >= k) {
                sb.append("H");
                p--;
            } else {
                k -= dp[p][q - 1];
                sb.append("V");
                q--;
            }
        }
        return sb.toString();
    }
}