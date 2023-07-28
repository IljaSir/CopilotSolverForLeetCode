class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = floor.charAt(i) - '0';
        }
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + a[i - 1];
        }
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] + a[i - 1] * i;
        }
        int[] g = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            g[i] = g[i - 1] + a[i - 1];
        }
        int[][] dp = new int[numCarpets + 1][n + 1];
        for (int i = 0; i <= numCarpets; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= numCarpets; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k < j; ++k) {
                    int l = j - k;
                    if (l > carpetLen) {
                        break;
                    }
                    int sum = s[j] - s[k];
                    int cost = f[j] - f[k] - g[k] * k;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + cost + l * sum);
                }
            }
        }
        return dp[numCarpets][n];
    }
}