class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        
        int[][][] dp = new int[2][n + 1][evil.length()];
        int[][][] diff = new int[2][n + 1][evil.length()];
        int mod = 1000000007;
        int[][] next = new int[evil.length()][26];
        for (int i = 0; i < evil.length(); i++) {
            for (int j = 0; j < 26; j++) {
                String s = evil.substring(0, i) + (char)('a' + j);
                for (int k = s.length(); k >= 0; k--) {
                    if (evil.startsWith(s.substring(s.length() - k))) {
                        next[i][j] = k;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (s1.charAt(i) <= 'a' + j && 'a' + j <= s2.charAt(i)) {
                    res += dfs(i, 0, j, s1, s2, evil, dp, diff, next, mod);
                    res %= mod;
                }
            }
        }
        return res;
    }
    
    private int dfs(int i, int j, int c, String s1, String s2, String evil, int[][][] dp, int[][][] diff, int[][] next, int mod) {
        if (dp[i & 1][j][c] != -1) {
            return dp[i & 1][j][c];
        }
        int res = 0;
        if (i == s1.length() - 1) {
            res = 1;
        } else {
            for (int k = 0; k < 26; k++) {
                int nj = next[j][k];
                if (nj != evil.length()) {
                    if (s1.charAt(i + 1) <= 'a' + k && 'a' + k <= s2.charAt(i + 1))
    }
}