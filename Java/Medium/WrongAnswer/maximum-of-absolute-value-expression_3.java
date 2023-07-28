class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int[][] dp = new int[n][4];
        dp[0][0] = arr1[0] + arr2[0];
        dp[0][1] = arr1[0] - arr2[0];
        dp[0][2] = -arr1[0] + arr2[0];
        dp[0][3] = -arr1[0] - arr2[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            int[] cur = new int[4];
            cur[0] = arr1[i] + arr2[i];
            cur[1] = arr1[i] - arr2[i];
            cur[2] = -arr1[i] + arr2[i];
            cur[3] = -arr1[i] - arr2[i];
            for (int j = 0; j < 4; j++) {
                int diff = Math.abs(i - 0);
                dp[i][j] = Math.max(dp[i][j], dp[0][j] + diff);
                dp[i][j] = Math.max(dp[i][j], cur[j] + diff);
                max = Math.max(max, dp[i][j]);
            }
            for (int j = 0; j < 4; j++) {
                int diff = Math.abs(i - (i - 1));
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + diff);
                dp[i][j] = Math.max(dp[i][j], cur[j] + diff);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}