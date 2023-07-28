class Solution {
    public int palindromePartition(String s, int k) {
        
        int n = s.length();
        int[][] f = new int[n + 1][n + 1];
        int[][] g = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i <= n; i++) {
            Arrays.fill(g[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i <= n; i++) {
            f[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            f[i][i + 1] = 0;
        }
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 2] = s.charAt(i) == s.charAt(i + 1) ? 0 : 1;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1];
                } else {
                    f[i][j] = f[i + 1][j - 1] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            g[i][1] = f[0][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int p = 0; p < i; p++) {
                    g[i][j] = Math.min(g[i][j], g[p][j - 1] + f[p + 1][i]);
                }
            }
        }
        return g[n - 1][k];
    }
}