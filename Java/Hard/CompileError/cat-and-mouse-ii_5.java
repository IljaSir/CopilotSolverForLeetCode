class Solution {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        
        int m = grid.length;
        int n = grid[0].length();
        int[][][] dp = new int[m][n][m * n + 1];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int cat = 0, mouse = 0, food = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == 'C') {
                    cat = i * n + j;
                } else if (grid[i].charAt(j) == 'M') {
                    mouse = i * n + j;
                } else if (grid[i].charAt(j) == 'F') {
                    food = i * n + j;
                }
            }
        }
        return dfs(grid, dp, dir, catJump, mouseJump, cat, mouse, 0);
    }
    private boolean dfs(String[] grid, int[][][] dp, int[][] dir, int catJump, int mouseJump, int cat, int mouse, int step) {
        if (step == 1000) {
            return false;
        }
        if (mouse == cat) {
            return false;
        }
        if (mouse == grid[0].length() * grid.length - 1) {
            return true;
        }
        if (dp[cat / grid[0].length()][cat % grid[0].length()][mouse] != 0) {
            return dp[cat / grid[0].length()][cat % grid[0].length()][mouse] == 1;
        }
        boolean mouseWin = false;
        for (int i = 0; i < 4; i++) {
            int nextMouse = mouse;
            for (int j = 0; j < mouseJump; j++) {
                int nextX = nextMouse / grid[0].length() + dir[i][0];
                int nextY = nextMouse % grid[0].length() + dir[i][1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length() || grid[nextX].charAt(nextY) == '#') {
                    break;
    }
}