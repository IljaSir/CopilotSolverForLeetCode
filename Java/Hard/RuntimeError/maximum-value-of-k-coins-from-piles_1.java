class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        int m = piles.get(0).size();
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            int[] p = new int[m];
            for (int j = 0; j < m; j++) {
                p[j] = piles.get(i).get(j);
            }
            Arrays.sort(p);
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + p[m - j * 2];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1] + p[m - j * 2], dp[i - 1][j]);
                }
            }
        }
        return dp[n - 1][k];
    }
}