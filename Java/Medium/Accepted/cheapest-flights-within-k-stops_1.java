class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[src][0] = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (dp[from][i - 1] != Integer.MAX_VALUE) {
                    dp[to][i] = Math.min(dp[to][i], dp[from][i - 1] + price);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k + 1; i++) {
            ans = Math.min(ans, dp[dst][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}