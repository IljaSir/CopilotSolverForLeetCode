class Solution {
    public int palindromePartition(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = getCost(s, i, j);
            }
        }
        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            f[i][1] = dp[0][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    if (f[l][j - 1] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[l][j - 1] + dp[l + 1][i]);
                    }
                }
            }
        }
        return f[n - 1][k];
    }

    public int getCost(String s, int i, int j) {
        int cost = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                cost++;
            }
            i++;
            j--;
        }
        return cost;
    }
}