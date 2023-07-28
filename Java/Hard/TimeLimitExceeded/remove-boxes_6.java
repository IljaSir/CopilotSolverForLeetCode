class Solution {
    public int removeBoxes(int[] boxes) {
        
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxes(boxes, 0, n - 1, 0, dp);
    }
    
    private int removeBoxes(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        while (i < j && boxes[j - 1] == boxes[j]) {
            j--;
            k++;
        }
        dp[i][j][k] = removeBoxes(boxes, i, j - 1, 0, dp) + (k + 1) * (k + 1);
        for (int m = i; m < j; m++) {
            if (boxes[m] == boxes[j]) {
                dp[i][j][k] = Math.max(dp[i][j][k], removeBoxes(boxes, i, m, k + 1, dp) + removeBoxes(boxes, m + 1, j - 1, 0, dp));
            }
        }
        return dp[i][j][k];
    }
}