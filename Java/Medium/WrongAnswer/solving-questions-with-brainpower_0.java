class Solution {
    public long mostPoints(int[][] questions) {
        
        int n = questions.length;
        int[] points = new int[n];
        int[] brainpower = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = questions[i][0];
            brainpower[i] = questions[i][1];
        }
        long[] dp = new long[n];
        dp[0] = points[0];
        for (int i = 1; i < n; i++) {
            long max = dp[i - 1];
            for (int j = i - 1; j >= 0 && i - j <= brainpower[j]; j--) {
                max = Math.max(max, dp[j] + points[i]);
            }
            dp[i] = max;
        }
        long max = 0;
        for (long x : dp) {
            max = Math.max(max, x);
        }
        return max;
    }
}