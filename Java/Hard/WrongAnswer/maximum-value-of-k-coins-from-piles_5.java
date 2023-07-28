class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        int m = piles.get(0).size();
        int[][] dp = new int[n + 1][k + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int take = 0;
                if (j - m >= 0) {
                    take = dp[i - 1][j - m];
                }
                if (j >= 1) {
                    take += piles.get(i - 1).get(m - j);
                }
                dp[i][j] = Math.max(dp[i - 1][j], take);
                if (j == k) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}