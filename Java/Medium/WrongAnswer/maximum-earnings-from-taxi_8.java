class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        Arrays.sort(rides, (a, b) -> (a[1] - b[1]));
        int[] dp = new int[n+1];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            while (j < rides.length && rides[j][1] == i) {
                int start = rides[j][0];
                int profit = rides[j][1] - rides[j][0] + rides[j][2];
                dp[i] = Math.max(dp[i], dp[start] + profit);
                j++;
            }
        }
        return dp[n];
    }
}