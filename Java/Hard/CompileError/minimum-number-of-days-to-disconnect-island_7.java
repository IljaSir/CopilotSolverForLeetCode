class Solution {
    public int minDays(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[] id = new int[m * n];
        int[] size = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            id[i] = i;
            size[i] = 1;
        }
        int count = 0;
        int land = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    land++;
                    for (int[] d : dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            union(id, size, i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (count == 1) {
                        grid[i][j] = 0;
                        int[] id2 = new int[m * n];
                        int[] size2 = new int[m * n];
                        for (int k = 0; k < m * n; k++) {
                            id2[k] = k;
                            size2[k] = 1;
                        }
                        int count2 = 0;
                        int land2 = 0;
                        for (int k = 0; k < m; k++) {
                            for (int l = 0; l < n; l++) {
                                if (grid[k][l] == 1) {
                                    land2++;
                                    for (int[] d : dir) {
                                        int x = k + d[0];
                                        int y = l + d[1];
                                        if (x >= 0 && x < m && y >= 0 && y < n && grid
    }
}