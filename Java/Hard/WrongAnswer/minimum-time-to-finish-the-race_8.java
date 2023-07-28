class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int n = tires.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = tires[i][0];
        }
        for(int i = 1; i < numLaps; i++) {
            int[] tmp = dp2;
            dp2 = dp;
            dp = tmp;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                min = Math.min(min, dp[j]);
            }
            for(int j = 0; j < n; j++) {
                dp2[j] = min + tires[j][0] + changeTime;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}