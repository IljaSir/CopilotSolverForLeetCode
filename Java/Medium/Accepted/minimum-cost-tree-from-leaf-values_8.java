class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        int len = arr.length;
        int[][] max = new int[len][len];
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            int curMax = 0;
            for (int j = i; j < len; j++) {
                curMax = Math.max(curMax, arr[j]);
                max[i][j] = curMax;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}