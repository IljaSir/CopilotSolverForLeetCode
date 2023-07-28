class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        long[] dp = new long[n + 1];
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
            while (j < rides.length && rides[j][1] == i) {
                dp[rides[j][1]] = Math.max(dp[rides[j][1]], dp[rides[j][0]] + rides[j][1] - rides[j][0] + rides[j][2]);
                j++;
            }
        }
        return dp[n];
    }
}