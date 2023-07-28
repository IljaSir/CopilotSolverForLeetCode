class Solution {
    public int minDistance(int[] houses, int k) {
        
        int n = houses.length;
        Arrays.sort(houses);
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = i + (j - i) / 2;
                for (int t = i; t <= j; t++) {
                    cost[i][j] += Math.abs(houses[t] - houses[mid]);
                }
            }
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dp[i][1] = cost[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int t = 0; t < i; t++) {
                    dp[i][j] = Math.min(dp[i][j], dp[t][j - 1] + cost[t + 1][i]);
                }
            }
        }
        return dp[n - 1][k];
    }
}