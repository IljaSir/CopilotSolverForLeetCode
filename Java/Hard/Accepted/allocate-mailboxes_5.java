class Solution {
    public int minDistance(int[] houses, int k) {
        
        Arrays.sort(houses);
        int n = houses.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = (i + j) / 2;
                for (int x = i; x <= j; x++) {
                    dist[i][j] += Math.abs(houses[x] - houses[mid]);
                }
            }
        }
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dist[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k && j <= i; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 0; x < i; x++) {
                    dp[i][j] = Math.min(dp[i][j], dp[x][j - 1] + dist[x + 1][i]);
                }
            }
        }
        return dp[n - 1][k - 1];
    }
}