class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length;
        int n = grid[0].length;
        // 1. build the union-find set
        UnionFind uf = new UnionFind(m * n + 1);
        // 2. mark the hits
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]] -= 1;
        }
        // 3. union the stable bricks
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int p = i * n + j;
                    if (i == 0) {
                        uf.union(p, m * n);
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        uf.union(p, p - n);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        uf.union(p, p - 1);
                    }
                }
            }
        }
        // 4. restore the hits
        int[] result = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) {
                continue;
            }
            int origin = uf.getSize(m * n);
            if (x == 0) {
                uf.union(y, m * n);
            }
            if (x > 0 && grid[x - 1][y] == 1) {
                uf.union(x * n + y, (x - 1) * n + y);
            }
            if (x < m - 1 && grid[x + 1][y] == 1) {
                uf.union(x * n + y, (x + 1) * n + y);
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                uf.union(x * n + y, x * n + y - 1);
            }
            if (y < n - 1 && grid[x][y + 1] == 1) {
                uf.union(x * n
    }
}