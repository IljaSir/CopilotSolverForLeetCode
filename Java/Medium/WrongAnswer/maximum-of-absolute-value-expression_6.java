class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = arr1[0] + arr2[0];
        dp[0][1] = arr1[0] - arr2[0];
        dp[0][2] = -arr1[0] + arr2[0];
        dp[0][3] = -arr1[0] - arr2[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int a = arr1[i] + arr2[i];
            int b = arr1[i] - arr2[i];
            int c = -arr1[i] + arr2[i];
            int d = -arr1[i] - arr2[i];
            dp[i][0] = Math.max(dp[i][0], Math.max(dp[i - 1][0], a) + i);
            dp[i][1] = Math.max(dp[i][1], Math.max(dp[i - 1][1], b) + i);
            dp[i][2] = Math.max(dp[i][2], Math.max(dp[i - 1][2], c) + i);
            dp[i][3] = Math.max(dp[i][3], Math.max(dp[i - 1][3], d) + i);
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
            ans = Math.max(ans, dp[i][2]);
            ans = Math.max(ans, dp[i][3]);
        }
        return ans;
    }
}