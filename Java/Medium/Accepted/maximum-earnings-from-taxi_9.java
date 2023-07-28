class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        // Sort the rides by the end time
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        // dp[i] is the maximum earnings for the first i rides
        // dp[i] = max(dp[i], dp[j] + rides[i][1] - rides[j][0] + rides[i][2]) for all j < i
        long[] dp = new long[rides.length + 1];
        for (int i = 1; i <= rides.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
            int j = i - 1;
            while (j >= 0 && rides[j][1] > rides[i - 1][0]) {
                j--;
            }
            dp[i] = Math.max(dp[i], dp[j + 1] + rides[i - 1][1] - rides[i - 1][0] + rides[i - 1][2]);
        }
        return dp[rides.length];
    }
}