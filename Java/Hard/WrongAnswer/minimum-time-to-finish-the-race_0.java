class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int n = tires.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = tires[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + tires[i][0]);
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + changeTime + tires[i][0]);
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + changeTime + tires[i][0]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i] * numLaps + (i + 1) * changeTime);
        }
        return res;
    }
}