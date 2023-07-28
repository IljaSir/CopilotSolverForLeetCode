class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int n = tires.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            int[] tire = tires[i];
            dp[i] = tire[0] + tire[1] * (numLaps - 1);
        }
        Arrays.sort(dp);
        int ans = dp[0];
        for (int i = 1; i < n; ++i) {
            int[] tire = tires[i];
            ans = Math.min(ans, dp[i] + tire[0] + (tire[1] - 1) * changeTime);
        }
        return ans;
    }
}