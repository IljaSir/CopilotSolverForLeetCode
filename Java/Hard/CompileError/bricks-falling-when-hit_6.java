class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length, n = grid[0].length;
        int[] res = new int[hits.length];
        int[][] grid2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid2[i][j] = grid[i][j];
            }
        }
        for (int[] hit : hits) {
            grid2[hit[0]][hit[1]] = 0;
        }
        UnionFind uf = new UnionFind(m, n, grid2);
        int[] dirs = new int[] {0, 1, 0, -1, 0};
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == 0) continue;
            int count = uf.count;
            if (x == 0) uf.union(x * n + y, m * n);
            for (int k = 0; k < 4; k++) {
                int nx = x + dirs[k], ny = y + dirs[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid2[nx][ny] == 1) {
                    uf.union(x * n + y, nx * n + ny);
                }
            }
            grid2[x][y] = 1;
            res[i] = Math.max(0, uf.count - count - 1);
        }
        return res;
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int m, int n, int[][] grid) {
            parent = new int[m * n + 1];
            rank = new int[m * n + 1];
            count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        parent[i * n + j] = i * n + j;
                        rank[i * n + j] = 1;
                        count++;
                    }
                }
    }
}