class Solution {
    public long mostPoints(int[][] questions) {
        
        Arrays.sort(questions, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int[] q = questions[i];
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (i + q[1] + 1 <= n) {
                dp[i + q[1] + 1] = Math.max(dp[i + q[1] + 1], dp[i] + q[0]);
            }
        }
        return dp[n];
    }
}