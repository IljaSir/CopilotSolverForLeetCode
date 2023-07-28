class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        int m = piles.get(0).size();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            List<Integer> p = piles.get(i);
            int sum = 0;
            for (int j = m - 1; j >= 0; j--) {
                sum += p.get(j);
                dp[i][j] = sum;
            }
        }
        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                f[i][j] = -1;
            }
        }
        return dfs(dp, f, 0, k);
    }
    int dfs(int[][] dp, int[][] f, int i, int k) {
        if (k == 0) return 0;
        if (i >= dp.length) return 0;
        if (f[i][k] != -1) return f[i][k];
        int res = 0;
        for (int j = 0; j <= k; j++) {
            res = Math.max(res, dfs(dp, f, i + 1, k - j) + dp[i][j]);
        }
        return f[i][k] = res;
    }
}