class Solution {
    public int removeBoxes(int[] boxes) {
        
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes, 0, n - 1, 0, dp);
    }
    private int helper(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];
        int result = (k + 1) * (k + 1) + helper(boxes, i + 1, j, 0, dp);
        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                result = Math.max(result, helper(boxes, i + 1, m - 1, 0, dp) + helper(boxes, m, j, k + 1, dp));
            }
        }
        dp[i][j][k] = result;
        return result;
    }
}