class Solution {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] sum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] memo = new int[n][n];
        return dfs(piles, 0, 1, sum, memo);
    }
    public int dfs(int[] piles, int i, int m, int[] sum, int[][] memo) {
        if (i == piles.length) {
            return 0;
        }
        if (2 * m >= piles.length - i) {
            return sum[i];
        }
        if (memo[i][m] != 0) {
            return memo[i][m];
        }
        int res = 0;
        for (int x = 1; x <= 2 * m; x++) {
            res = Math.max(res, sum[i] - dfs(piles, i + x, Math.max(m, x), sum, memo));
        }
        memo[i][m] = res;
        return res;
    }
}