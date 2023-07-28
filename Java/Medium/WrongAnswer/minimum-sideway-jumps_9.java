class Solution {
    public int minSideJumps(int[] obstacles) {
        
        int[] dp = new int[3];
        for (int i = 0; i < obstacles.length - 1; i++) {
            if (obstacles[i + 1] == 0) {
                dp[0] = Math.min(dp[0], Math.min(dp[1], dp[2]) + 1);
                dp[1] = Math.min(dp[1], Math.min(dp[0], dp[2]) + 1);
                dp[2] = Math.min(dp[2], Math.min(dp[0], dp[1]) + 1);
            } else {
                dp[obstacles[i + 1] - 1] = Integer.MAX_VALUE;
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}