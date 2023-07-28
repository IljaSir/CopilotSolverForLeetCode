class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[hits.length];
        for (int i = 0; i < hits.length; i++) {
            grid[hits[i][0]][hits[i][1]]--;
        }
        int[] parent = new int[m * n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        union(parent, i * n + j, m * n);
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        union(parent, i * n + j, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        union(parent, i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            grid[x][y]++;
            if (grid[x][y] == 1) {
                int before = find(parent, m * n);
                if (x == 0) {
                    union(parent, x * n + y, m * n);
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) {
                        continue;
                    }
                    union(parent, x * n + y, nx * n + ny);
                }
                int after = find(parent, m * n);
                res[i] = Math.max(0, after - before - 1);
    }
}