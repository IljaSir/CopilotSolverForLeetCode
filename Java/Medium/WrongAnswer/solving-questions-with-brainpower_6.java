class Solution {
    public long mostPoints(int[][] questions) {
        
        Arrays.sort(questions, (a, b) -> a[1] - b[1]);
        int n = questions.length;
        int[] points = new int[n];
        int[] bp = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = questions[i][0];
            bp[i] = questions[i][1];
        }
        long[] dp = new long[n];
        dp[0] = points[0];
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && bp[i] - bp[j] <= i - j) {
                j--;
            }
            if (j == -1) {
                dp[i] = points[i];
            } else {
                dp[i] = dp[j] + points[i];
            }
            if (i > 1) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
        }
        return dp[n - 1];
    }
}