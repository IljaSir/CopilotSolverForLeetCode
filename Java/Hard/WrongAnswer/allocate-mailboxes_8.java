class Solution {
    public int minDistance(int[] houses, int k) {
        
        int n = houses.length;
        Arrays.sort(houses);
        int[][] dp = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][1] = cost(houses, 0, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int p = 0; p < i; p++) {
                    dp[i][j] = Math.min(dp[i][j], dp[p][j-1] + cost(houses, p+1, i));
                }
            }
        }
        return dp[n-1][k];
    }
    private int cost(int[] houses, int l, int r) {
        int median = houses[(l+r)/2];
        int cost = 0;
        for (int i = l; i <= r; i++) {
            cost += Math.abs(houses[i] - median);
        }
        return cost;
    }
}