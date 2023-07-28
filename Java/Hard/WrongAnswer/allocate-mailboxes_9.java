class Solution {
    public int minDistance(int[] houses, int k) {
        
        Arrays.sort(houses);
        int n = houses.length;
        int[][] dp = new int[n][k];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                int median = houses[(i + j) / 2];
                int cost = 0;
                for (int m = j; m <= i; m++) cost += Math.abs(houses[m] - median);
                if (j == 0) {
                    dp[i][0] = cost;
                } else {
                    for (int m = 1; m < k; m++) {
                        dp[i][m] = Math.min(dp[i][m], dp[j - 1][m - 1] + cost);
                    }
                }
            }
        }
        return dp[n - 1][k - 1];
    }
}