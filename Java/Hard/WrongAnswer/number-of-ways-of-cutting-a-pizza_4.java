class Solution {
    public int ways(String[] pizza, int k) {
        
        int rows = pizza.length;
        int cols = pizza[0].length();
        int[][] sum = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }
        int[][][] dp = new int[rows][cols][k];
        return dfs(pizza, k, 0, 0, sum, dp);
    }
    private int dfs(String[] pizza, int k, int row, int col, int[][] sum, int[][][] dp) {
        if (sum[row][col] == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        if (dp[row][col][k - 1] != 0) {
            return dp[row][col][k - 1];
        }
        int rows = pizza.length;
        int cols = pizza[0].length();
        int res = 0;
        for (int i = row + 1; i < rows; i++) {
            if (sum[i][col] - sum[row][col] > 0) {
                res = (res + dfs(pizza, k - 1, i, col, sum, dp)) % 1000000007;
            }
        }
        for (int j = col + 1; j < cols; j++) {
            if (sum[row][j] - sum[row][col] > 0) {
                res = (res + dfs(pizza, k - 1, row, j, sum, dp)) % 1000000007;
            }
        }
        dp[row][col][k - 1] = res;
        return res;
    }
}