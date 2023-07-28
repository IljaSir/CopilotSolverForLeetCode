class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n - 1 && cur[1] == n - 1) return grid[n - 1][n - 1];
            for (int i = 0; i < 8; i++) {
                int x = cur[0] + dir[i][0];
                int y = cur[1] + dir[i][1];
                if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0) {
                    q.add(new int[]{x, y});
                    grid[x][y] = grid[cur[0]][cur[1]] + 1;
                }
            }
        }
        return -1;
    }
}