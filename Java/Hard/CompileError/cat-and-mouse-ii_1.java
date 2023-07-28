class Solution {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        
        int rows = grid.length;
        int cols = grid[0].length();
        int[][][] dp = new int[rows][cols][rows*cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < rows*cols; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(grid, 0, 0, 0, catJump, mouseJump, dp) == 1;
    }
    private int dfs(String[] grid, int m, int c, int t, int catJump, int mouseJump, int[][][] dp) {
        if (dp[m][c][t] != -1) {
            return dp[m][c][t];
        }
        int rows = grid.length;
        int cols = grid[0].length();
        int[] mouse = getPos(grid, m);
        int[] cat = getPos(grid, c);
        int[] food = getPos(grid, rows*cols-1);
        if (t % 2 == 0) {
            if (mouse[0] == food[0] && mouse[1] == food[1]) {
                return dp[m][c][t] = 1;
            }
            for (int i = 1; i <= mouseJump; i++) {
                int[] next = getNextPos(grid, mouse[0], mouse[1], i, t);
                if (next[0] == -1 && next[1] == -1) {
                    break;
                }
                int nextPos = next[0]*cols + next[1];
                if (dfs(grid, nextPos, c, t+1, catJump, mouseJump, dp) == 0) {
                    return dp[m][c][t] = 1;
                }
            }
        } else {
            if (cat[0] == mouse[0] && cat[1] == mouse[1]) {
                return dp[m][c][t] = 0;
            }
            if (cat[0] == food[0] && cat[1] == food[1]) {
                return dp[m][c][t] = 0;
            }
            for (int i
    }
}