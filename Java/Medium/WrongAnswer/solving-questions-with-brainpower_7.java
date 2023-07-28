class Solution {
    public long mostPoints(int[][] questions) {
        
        Arrays.sort(questions, (a, b) -> b[0] - a[0]);
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int p = questions[i][0], bp = questions[i][1];
            for (int j = n; j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[Math.max(0, j - bp - 1)] + p);
            }
        }
        long res = 0;
        for (int i = 0; i <= n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}