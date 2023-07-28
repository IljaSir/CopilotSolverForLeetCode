class Solution {
    public int minSideJumps(int[] obstacles) {
        
        int[] dp = new int[]{1, 0, 1};
        for (int i = 1; i < obstacles.length; i++) {
            if (obstacles[i] > 0) {
                dp[obstacles[i] - 1] = 1000000;
            }
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] != j + 1) {
                    dp[j] = Math.min(dp[j], Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + 1);
                }
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}