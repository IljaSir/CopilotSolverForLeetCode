class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int l = 0;
        int r = n*n-1;
        while (l < r) {
            int m = (l+r)/2;
            vector<vector<bool>> visited(n, vector<bool>(n, false));
            if (dfs(grid, visited, 0, 0, m)) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    
    bool dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited, int x, int y, int m) {
        int n = grid.size();
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] > m) {
            return false;
        }
        if (x == n-1 && y == n-1) {
            return true;
        }
        visited[x][y] = true;
        return dfs(grid, visited, x+1, y, m) || dfs(grid, visited, x-1, y, m) || dfs(grid, visited, x, y+1, m) || dfs(grid, visited, x, y-1, m);
    }
};