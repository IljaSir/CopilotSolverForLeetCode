class Solution {
    public long mostPoints(int[][] questions) {
        
        Arrays.sort(questions, (a, b) -> a[1] - b[1]);
        long[] dp = new long[questions.length];
        dp[0] = questions[0][0];
        long max = dp[0];
        for (int i = 1; i < questions.length; i++) {
            dp[i] = questions[i][0];
            int j = i - 1;
            while (j >= 0 && questions[i][1] - questions[j][1] <= j + 1) {
                dp[i] = Math.max(dp[i], dp[j] + questions[i][0]);
                j--;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}