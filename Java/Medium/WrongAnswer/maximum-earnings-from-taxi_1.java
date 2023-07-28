class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        long[] dp = new long[n + 1];
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            while (j < rides.length && rides[j][0] == i) {
                int start = rides[j][0];
                int end = rides[j][1];
                int tip = rides[j][2];
                dp[end] = Math.max(dp[end], dp[start] + end - start + tip);
                j++;
            }
        }
        return dp[n];
    }
}