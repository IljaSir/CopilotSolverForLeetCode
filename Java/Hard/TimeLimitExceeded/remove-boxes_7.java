class Solution {
    public int removeBoxes(int[] boxes) {
        
        int N = boxes.length;
        int[][][] dp = new int[N][N][N];
        return dfs(boxes, dp, 0, N - 1, 0);
    }

    private int dfs(int[] boxes, int[][][] dp, int i, int j, int k) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];
        while (i < j && boxes[i] == boxes[i + 1]) {
            i++;
            k++;
        }
        int res = (k + 1) * (k + 1) + dfs(boxes, dp, i + 1, j, 0);
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                res = Math.max(res, dfs(boxes, dp, i + 1, m - 1, 0) + dfs(boxes, dp, m, j, k + 1));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}