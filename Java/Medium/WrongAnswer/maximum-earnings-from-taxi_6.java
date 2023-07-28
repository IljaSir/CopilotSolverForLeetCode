class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            int idx = Arrays.binarySearch(rides, new int[]{0, i + 1, 0}, (a, b) -> a[1] - b[1]);
            if (idx < 0) {
                idx = -idx - 2;
            }
            if (idx >= 0) {
                dp[rides[idx][1]] = Math.max(dp[rides[idx][1]], dp[rides[idx][0]] + rides[idx][1] - rides[idx][0] + rides[idx][2]);
            }
        }
        return dp[n];
    }
}