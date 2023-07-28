class Solution {
    public int minDistance(int[] houses, int k) {
        
        int n = houses.length;
        Arrays.sort(houses);
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = (i + j) / 2;
                for (int m = i; m <= j; m++) {
                    cost[i][j] += Math.abs(houses[m] - houses[mid]);
                }
            }
        }
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            dp[i][0] = cost[0][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < i; m++) {
                    dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + cost[m + 1][i]);
                }
            }
        }
        return dp[n - 1][k - 1];
    }
}