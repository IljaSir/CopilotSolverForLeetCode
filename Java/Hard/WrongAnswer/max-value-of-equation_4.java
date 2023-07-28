class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int n = points.length;
        int[] dp = new int[n];
        dp[0] = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], points[i - 1][1] - points[i - 1][0]);
            res = Math.max(res, dp[i] + points[i][1] + points[i][0]);
            int j = i - 1;
            while (j >= 0 && points[i][0] - points[j][0] <= k) {
                res = Math.max(res, points[i][1] + points[i][0] + points[j][1] - points[j][0]);
                j--;
            }
        }
        return res;
    }
}