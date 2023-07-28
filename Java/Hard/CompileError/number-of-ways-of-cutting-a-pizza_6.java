class Solution {
    public int ways(String[] pizza, int k) {
        
        int row = pizza.length;
        int col = pizza[0].length();
        int[][] sum = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    sum[i][j] = 1;
                }
                if (i > 0) {
                    sum[i][j] += sum[i - 1][j];
                }
                if (j > 0) {
                    sum[i][j] += sum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sum[i][j] -= sum[i - 1][j - 1];
                }
            }
        }
        int[][][] dp = new int[k][row][col];
        return dfs(0, 0, 0, sum, dp);
    }
    
    private int dfs(int x, int y, int k, int[][] sum, int[][][] dp) {
        if (dp[k][x][y] > 0) {
            return dp[k][x][y];
        }
        if (k == dp.length - 1) {
            if (sum[sum.length - 1][sum[0].length - 1] - sum[x][sum[0].length - 1] - sum[sum.length - 1][y] + sum[x][y] > 0) {
                dp[k][x][y] = 1;
                return 1;
            } else {
                return 0;
            }
        }
        int count = 0;
        for (int i = x + 1; i < sum.length; i++) {
            if (sum[i - 1][sum[0].length - 1] - sum[x][sum[0].length - 1] - sum[i - 1][y] + sum[x][y] > 0) {
                count = (count + dfs(i, y, k + 1, sum, dp)) % 1000000007;
            }
        }
        for (int i = y + 1; i < sum[0].length; i++) {
            if (sum[sum.length - 1][i -
    }
}