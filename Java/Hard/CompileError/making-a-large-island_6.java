class Solution {
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] id = new int[n][n];
        int[] size = new int[n * n + 1];
        int idCount = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && id[i][j] == 0) {
                    int area = dfs(grid, i, j, idCount, id, size, dir);
                    idCount++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            set.add(id[x][y]);
                        }
                    }
                    for (int k : set) {
                        area += size[k];
                    }
                    max = Math.max(max, area);
                }
            }
        }
        if (max == 0) {
            max = n * n;
        }
        return max;
    }
}