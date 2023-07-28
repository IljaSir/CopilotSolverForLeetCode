class Solution {
    public int removeBoxes(int[] boxes) {
        
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxes(boxes, dp, 0, n - 1, 0);
    }

    private int removeBoxes(int[] boxes, int[][][] dp, int i, int j, int k) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];
        while (i < j && boxes[i] == boxes[i + 1]) {
            i++;
            k++;
        }
        int res = (k + 1) * (k + 1) + removeBoxes(boxes, dp, i + 1, j, 0);
        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, removeBoxes(boxes, dp, i + 1, m - 1, 0) + removeBoxes(boxes, dp, m, j, k + 1));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}