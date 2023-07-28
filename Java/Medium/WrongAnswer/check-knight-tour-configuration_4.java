class Solution {
    public boolean checkValidGrid(int[][] grid) {
        
        int n = grid.length;
        int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    for(int[] d: dir) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isValid(int[][] grid) {
        int n = grid.length;
        int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int cnt = 0;
                for(int[] d: dir) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == grid[i][j] + 1) {
                        cnt++;
                    }
                }
                if(cnt == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}