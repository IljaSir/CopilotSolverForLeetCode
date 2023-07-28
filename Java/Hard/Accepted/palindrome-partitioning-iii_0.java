class Solution {
    public int palindromePartition(String s, int k) {
        
        int n = s.length();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                for (int l = i, r = j; l < r; ++l, --r) {
                    cost[i][j] += s.charAt(l) != s.charAt(r) ? 1 : 0;
                }
            }
        }
        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; ++i) {
            f[i][1] = cost[0][i];
        }
        for (int j = 2; j <= k; ++j) {
            for (int i = j - 1; i < n; ++i) {
                for (int p = j - 2; p < i; ++p) {
                    f[i][j] = Math.min(f[i][j], f[p][j - 1] + cost[p + 1][i]);
                }
            }
        }
        return f[n - 1][k];
    }
}