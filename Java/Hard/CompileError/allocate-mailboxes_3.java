class Solution {
    public int minDistance(int[] houses, int k) {
        
        int n = houses.length;
        Arrays.sort(houses);
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = (i + j) / 2;
                for (int k = i; k <= j; k++) {
                    cost[i][j] += Math.abs(houses[k] - houses[mid]);
                }
            }
        }
        int[][] dp = new int[k][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = cost[0][i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i - 1; m < j; m++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][m] + cost[m + 1][j]);
                }
            }
        }
        return dp[k - 1][n - 1];
    }
}