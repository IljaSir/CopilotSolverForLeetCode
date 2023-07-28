class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int n = tires.length;
        int[][] dp = new int[n][numLaps + 1];
        Arrays.sort(tires, (a, b) -> a[0] * b[1] - b[0] * a[1]);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i][1] = tires[i][0];
            for (int j = 2; j <= numLaps; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + tires[i][0] + (i != k ? changeTime : 0));
                }
            }
            min = Math.min(min, dp[i][numLaps]);
        }
        return min;
    }
}