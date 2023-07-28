class Solution {
    public int minDistance(int[] houses, int k) {
        
        int n = houses.length;
        Arrays.sort(houses);
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + houses[i];
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + cost(sum, l, i));
                }
            }
        }
        return dp[n][k];
    }
    private int cost(int[] sum, int i, int j) {
        int m = (i + j) / 2;
        return (sum[j] - sum[m]) - (sum[m] - sum[i]);
    }
}