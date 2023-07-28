class Solution {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        
        int m = grid.length;
        int n = grid[0].length();
        int[][][] dp = new int[m][n][m*n+1];
        int[] cat = new int[2];
        int[] mouse = new int[2];
        int[] food = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == 'C') {
                    cat[0] = i;
                    cat[1] = j;
                }
                if (grid[i].charAt(j) == 'M') {
                    mouse[0] = i;
                    mouse[1] = j;
                }
                if (grid[i].charAt(j) == 'F') {
                    food[0] = i;
                    food[1] = j;
                }
            }
        }
        return dfs(grid, cat, mouse, food, catJump, mouseJump, 0, dp);
    }

    private boolean dfs(String[] grid, int[] cat, int[] mouse, int[] food, int catJump, int mouseJump, int turn, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length();
        if (turn == m*n) {
            return false;
        }
        if (dp[mouse[0]][mouse[1]][turn] != 0) {
            return dp[mouse[0]][mouse[1]][turn] == 1;
        }
        if (mouse[0] == cat[0] && mouse[1] == cat[1]) {
            dp[mouse[0]][mouse[1]][turn] = -1;
            return false;
        }
        if (mouse[0] == food[0] && mouse[1] == food[1]) {
            dp[mouse[0]][mouse[1]][turn] = 1;
            return true;
        }
        if (turn % 2 == 0) {
            boolean canWin = false;
            for (int i = 1; i <= mouseJump; i++) {
                int[] next = new int[]{mouse[0] - i, mouse[1]};
                if (next[0] < 0 || grid[next[0]].charAt(next[1]) == '#
    }
}