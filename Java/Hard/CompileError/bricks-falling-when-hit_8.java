class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[hits.length];
        UnionFind uf = new UnionFind(m * n + 1);
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                uf.union(j, m * n);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (grid[i - 1][j] == 1) {
                        uf.union(getIndex(i, j, n), getIndex(i - 1, j, n));
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        uf.union(getIndex(i, j, n), getIndex(i, j - 1, n));
                    }
                }
            }
        }
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 2) {
                int origin = uf.getSize(m * n);
                if (x == 0) {
                    uf.union(y, m * n);
                }
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (inArea(newX, newY, m, n) && grid[newX][newY] == 1) {
                        uf.union(getIndex(x, y, n), getIndex(newX, newY, n));
                    }
                }
                int current = uf.getSize(m * n);
                result[i] = Math.max(0, current - origin - 1);
    }
}