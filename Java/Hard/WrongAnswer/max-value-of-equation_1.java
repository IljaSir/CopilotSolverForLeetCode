class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int n = points.length;
        int[] dp = new int[n];
        dp[0] = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i - 1] + points[i][0] - points[i][1]);
            dp[i] = Math.max(dp[i - 1], points[i][1] - points[i][0] + max);
            if (i > k) {
                if (points[i - k][0] + points[i - k][1] > dp[i - k]) {
                    max = Math.max(max, points[i - k][0] - points[i - k][1]);
                }
            }
        }
        return dp[n - 1];
    }
}