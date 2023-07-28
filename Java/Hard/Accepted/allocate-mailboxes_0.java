class Solution {
    public int minDistance(int[] houses, int k) {
        
        Arrays.sort(houses);
        int n = houses.length;
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = (i + j) / 2;
                for (int h = i; h <= j; h++) {
                    cost[i][j] += Math.abs(houses[h] - houses[mid]);
                }
            }
        }
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            dp[i][0] = cost[0][i];
        }
        for (int j = 1; j < k; j++) {
            for (int i = j; i < n; i++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int h = j - 1; h < i; h++) {
                    dp[i][j] = Math.min(dp[i][j], dp[h][j - 1] + cost[h + 1][i]);
                }
            }
        }
        return dp[n - 1][k - 1];
    }
}