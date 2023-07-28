class Solution {
    public int removeBoxes(int[] boxes) {
        
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxes(boxes, 0, n - 1, 0, dp);
    }

    public int removeBoxes(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        while (i < j && boxes[j] == boxes[j - 1]) {
            j--;
            k++;
        }
        int res = (k + 1) * (k + 1) + removeBoxes(boxes, i, j - 1, 0, dp);
        for (int m = i; m < j; m++) {
            if (boxes[m] == boxes[j]) {
                res = Math.max(res, removeBoxes(boxes, i, m, k + 1, dp) + removeBoxes(boxes, m + 1, j - 1, 0, dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}