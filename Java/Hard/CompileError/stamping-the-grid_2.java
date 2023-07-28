class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[] visited = new boolean[m * n];
        int[] stamp = new int[stampHeight * stampWidth];
        for (int i = 0; i < stampHeight; i++) {
            for (int j = 0; j < stampWidth; j++) {
                stamp[i * stampWidth + j] = 1;
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        while (!list.isEmpty()) {
            List<int[]> next = new ArrayList<>();
            for (int[] point : list) {
                if (visited[point[0] * n + point[1]]) {
                    continue;
                }
                boolean flag = false;
                for (int i = 0; i <= m - stampHeight; i++) {
                    for (int j = 0; j <= n - stampWidth; j++) {
                        if (isMatch(grid, stamp, i, j, point)) {
                            next.add(new int[]{i, j});
                            flag = true;
                        }
                    }
                }
                if (!flag) {
                    return false;
                }
                visited[point[0] * n + point[1]] = true;
            }
            list = next;
        }
        return true;
    }
}