class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        
        int n = dist.length;
        double[] dp = new double[n + 1];
        Arrays.fill(dp, Double.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            double t = (double) dist[i] / speed;
            double[] ndp = new double[n + 1];
            Arrays.fill(ndp, Double.MAX_VALUE);
            for (int j = 0; j <= i; j++) {
                ndp[j] = Math.min(ndp[j], Math.ceil(dp[j] + t));
                ndp[j + 1] = Math.min(ndp[j + 1], dp[j] + t);
            }
            dp = ndp;
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] <= hoursBefore) {
                return i;
            }
        }
        return -1;
    }
}