class Solution {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        
        int m = grid.length;
        int n = grid[0].length();
        int[][][] dp = new int[m][n][m*n+1];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int[] mouse = new int[2];
        int[] cat = new int[2];
        int[] food = new int[2];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i].charAt(j) == 'M') {
                    mouse[0] = i;
                    mouse[1] = j;
                } else if(grid[i].charAt(j) == 'C') {
                    cat[0] = i;
                    cat[1] = j;
                } else if(grid[i].charAt(j) == 'F') {
                    food[0] = i;
                    food[1] = j;
                }
            }
        }
        return dfs(grid, mouse, cat, food, dp, catJump, mouseJump, 0);
    }
    
    public boolean dfs(String[] grid, int[] mouse, int[] cat, int[] food, int[][][] dp, int catJump, int mouseJump, int turn) {
        int m = grid.length;
        int n = grid[0].length();
        if(mouse[0] == food[0] && mouse[1] == food[1]) {
            return true;
        }
        if(cat[0] == food[0] && cat[1] == food[1]) {
            return false;
        }
        if(turn == 1000) {
            return false;
        }
        if(dp[mouse[0]][mouse[1]][turn] != -1) {
            return dp[mouse[0]][mouse[1]][turn] == 1;
        }
        boolean canWin = false;
        if(turn % 2 == 0) {
            for(int i=0; i<4; i++) {
                int[] nextMouse = new int[2];
                nextMouse[0] = mouse[0];
                nextMouse[1] = mouse[1];
                for(int j=0; j<mouseJump; j++) {
                    next
    }
}