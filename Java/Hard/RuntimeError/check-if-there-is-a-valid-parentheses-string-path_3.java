class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dir = new int[][][]{
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{-1, 0}, {0, 1}},
            {{-1, 0}, {0, -1}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}}
        };
        int[][][] dir2 = new int[][][]{
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{-1, 0}, {0, 1}},
            {{-1, 0}, {0, -1}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}}
        };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            if (i == m - 1 && j == n - 1) {
                return true;
            }
            int[][] d = dir[grid[i][j] - '1'];
            for (int k = 0; k < d.length; k++) {
                int x = i + d[k][0];
                int y = j + d[k][1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                int[][] d2 = dir2[grid[x][y] - '1'];
                for (int l = 0; l < d2.length; l++) {
                    if (d2[l][0] == -d[k][0] && d2[l][1] == -d[k][1]) {
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                        break;
                    }
                }
            }
        }
        return false;
    }
}