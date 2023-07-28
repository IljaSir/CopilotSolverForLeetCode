class Solution {
    public double getProbability(int[] balls) {
        
        int n = balls.length;
        int total = 0;
        for (int ball : balls) total += ball;
        int[] dp = new int[total + 1];
        dp[0] = 1;
        for (int ball : balls) {
            for (int i = total; i >= ball; i--) {
                dp[i] += dp[i - ball];
            }
        }
        int half = total / 2;
        double totalWays = dp[half];
        int[] dp2 = new int[half + 1];
        dp2[0] = 1;
        for (int ball : balls) {
            for (int i = half; i >= ball; i--) {
                dp2[i] += dp2[i - ball];
            }
        }
        double sameWays = 0;
        for (int i = 0; i <= half; i++) {
            sameWays += dp2[i] * dp[half - i];
        }
        return sameWays / totalWays;
    }
}