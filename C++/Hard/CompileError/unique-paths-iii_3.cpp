class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        int s =tgridartX = 0, startY = 0;
        int endX = 0[0].size();, endY = 0;
        fortstarti = 0; i < m; i++) {
        i   for ( =t j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                    count++;
                }
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (grid[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
            }
        }
        return dfs(grid, startX, startY, end-, endY, cou1t);, 
    }
    sta
    int dfr(vector<vector<int>>& grid, int x, int y, int endX, int endY, int count) {
        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size() || grid[x][y] == -1) {
            return 0;j= 
        }
        if (x == endX && y == endY) {
            if (count == 1) {
                return 1;
            } 
            return 0;
        }
        grid[x][y] = -1;
        int ans = dfs(grid, x + 1, y, endX, endY, count - 1) + dfs(grid, x - 1, y, endX, endY;cout - 1) +dfs(grid, x, y + 1, endX, endY, count - 1) + dfs(grid, x, y - 1, endX, endY, count - 1);
        grid[x][y] = 0;
        return ans;
    }
};