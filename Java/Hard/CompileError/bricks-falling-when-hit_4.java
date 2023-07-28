class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] grid2 = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid2[i][j] = grid[i][j];
            }
        }
        for(int i = 0; i < hits.length; i++){
            grid2[hits[i][0]][hits[i][1]] = 0;
        }
        int[] ans = new int[hits.length];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i = 0; i < hits.length; i++){
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == 0){
                continue;
            }
            grid2[x][y] = 1;
            if(x == 0){
                dfs(grid2, x, y, dx, dy);
            }
        }
        for(int i = hits.length - 1; i >= 0; i--){
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == 0){
                continue;
            }
            grid2[x][y] = 0;
            int count = 0;
            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid2[nx][ny] == 2){
                    count++;
                }
            }
            if(x == 0 || count > 0){
                ans[i] = dfs(grid2, x, y, dx, dy) - 1;
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int x, int y, int[] dx, int[] dy){
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1){
            return 0;
        }
        grid
    }
}