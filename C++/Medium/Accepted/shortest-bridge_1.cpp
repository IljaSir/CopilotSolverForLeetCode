class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        vector<pair<int, int>> island1;
        vector<pair<int, int>> island2;
        bool found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (!found) {
                        dfs(grid, island1, i, j);
                    } else {
                        dfs(grid, island2, i, j);
                    }
                    found = true;
                }
            }
        }
        int ans = INT_MAX;
        for (auto& p1 : island1) {
            for (auto& p2 : island2) {
                ans = min(ans, abs(p1.first - p2.first) + abs(p1.second - p2.second) - 1);
            }
        }
        return ans;
    }
    void dfs(vector<vector<int>>& grid, vector<pair<int, int>>& island, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.size() || y >= grid[0].size() || grid[x][y] == 0) {
            return;
        }
        island.push_back({x, y});
        grid[x][y] = 0;
        dfs(grid, island, x + 1, y);
        dfs(grid, island, x - 1, y);
        dfs(grid, island, x, y + 1);
        dfs(grid, island, x, y - 1);
    }
};