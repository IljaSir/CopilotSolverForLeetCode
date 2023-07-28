class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        int[] visited = new int[n * n];
        int x = 0, y = 0;
        for (int i = 0; i < n * n; i++) {
            int nx = x + dx[grid[x][y]];
            int ny = y + dy[grid[x][y]];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) return false;
            if (visited[grid[nx][ny]] == 1) return false;
            visited[grid[nx][ny]] = 1;
            x = nx;
            y = ny;
        }
        return true;
    }
}