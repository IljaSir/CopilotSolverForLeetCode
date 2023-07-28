class Solution {
    public double getProbability(int[] balls) {
        
        int n = balls.length;
        long total = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= balls[i]; j++) {
                total *= j;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += balls[i];
        }
        int half = sum / 2;
        int[] dp = new int[half + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = half; j >= 0; j--) {
                for (int k = 1; k <= balls[i] && k + j <= half; k++) {
                    dp[j + k] += dp[j];
                }
            }
        }
        long cnt = 0;
        for (int i = 0; i <= half; i++) {
            cnt += (long) dp[i] * dp[half - i];
        }
        return (double) cnt / total;
    }
}