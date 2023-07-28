class Solution {
    public int numSubmat(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                    int min = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        min = Math.min(min, dp[k][j]);
                        ans += min;
                    }
                }
            }
        }
        return ans;
    }
}