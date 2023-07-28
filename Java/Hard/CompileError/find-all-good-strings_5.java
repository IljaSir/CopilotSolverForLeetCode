class Solution {
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][evil.length()];
        int[][][] memo = new int[n + 1][evil.length()][26];
        int[][][] memo2 = new int[n + 1][evil.length()][26];
        int[][][] memo3 = new int[n + 1][evil.length()][26];
        int[][][] memo4 = new int[n + 1][evil.length()][26];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < evil.length(); j++) {
                Arrays.fill(memo[i][j], -1);
                Arrays.fill(memo2[i][j], -1);
                Arrays.fill(memo3[i][j], -1);
                Arrays.fill(memo4[i][j], -1);
            }
        }
        return dfs(n, s1, s2, evil, 0, 0, dp, memo, memo2, memo3, memo4) % MOD;
    }
    private int dfs(int n, String s1, String s2, String evil, int i, int j, int[][] dp, int[][][] memo, int[][][] memo2, int[][][] memo3, int[][][] memo4) {
        if (i == n) {
            return 1;
        }
        if (j == evil.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int count = 0;
        int start = s1.charAt(i) - 'a';
        int end = s2.charAt(i) - 'a';
        for (int k = start; k <= end; k++) {
            int next = j;
            while (next > 0 && k != evil.charAt(next) - 'a') {
                next = memo[i][j][k];
            }
            if (k == evil.charAt(next) - 'a') {
                next++;
            }
            if (next == evil.length()) {
                continue;
            }
            if (k == start && k == end) {
                if (memo2[i][j][k] == -1) {
                    memo2[i][j][k] = dfs
    }
}