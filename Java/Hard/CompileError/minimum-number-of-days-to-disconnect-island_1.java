class Solution {
    public int minDays(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int islands = 0;
        int[] parent = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    parent[i * n + j] = i * n + j;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            union(parent, i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        if (islands == 0) {
            return 0;
        }
        if (islands == 1) {
            return 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int newIslands = 0;
                    for (int k = 0; k < m * n; k++) {
                        parent[k] = k;
                    }
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (grid[k][l] == 1) {
                                newIslands++;
                                parent[k * n + l] = k * n + l;
                            }
                        }
                    }
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (grid[k
    }
}