class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        long[] dp = new long[n + 1];
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            while (j < rides.length && rides[j][1] == i) {
                int start = rides[j][0];
                dp[i] = Math.max(dp[i], dp[start] + (long) (rides[j][1] - start + rides[j][2]));
                j++;
            }
        }
        return dp[n];
    }
}