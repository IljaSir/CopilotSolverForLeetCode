class Solution {
    public int minDays(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        if (m == 0 || n == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] d = new int[m][n];
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = grid[i][j];
                g[i][j] = grid[i][j];
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) {
                    dfs(g, i, j, dirs);
                    cnt++;
                }
            }
        }
        if (cnt > 1) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 1) {
                    d[i][j] = 0;
                    cnt = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            g[k][l] = d[k][l];
                        }
                    }
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (g[k][l] == 1) {
                                dfs(g, k, l, dirs);
                                cnt++;
                            }
                        }
                    }
                    if (cnt > 1) return 1;
                    d[i][j] = 1;
                }
            }
        }
        return 2;
    }
}