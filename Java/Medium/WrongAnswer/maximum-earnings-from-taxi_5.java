class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        long[] dp = new long[n + 1];
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < rides.length; i++) {
            int[] ride = rides[i];
            int start = ride[0], end = ride[1], tip = ride[2];
            dp[end] = Math.max(dp[end], dp[start] + end - start + tip);
            int j = i + 1;
            for (; j < rides.length && rides[j][1] == end; j++) {
                dp[end] = Math.max(dp[end], dp[start] + rides[j][1] - rides[j][0] + rides[j][2]);
            }
            i = j - 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[n];
    }
}