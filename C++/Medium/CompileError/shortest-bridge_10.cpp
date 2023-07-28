class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int n = grid.size();
        queue<pair<int, int>> q;
        bool found = false;
        for (int i = 0; i < n; ++i) {
            if (found) break;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    found = true;
                    break;
                }
            }
        }
        int ans = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto p = q.front();
                q.pop();
                int x = p.first;
                int y = p.second;
                if (x > 0 && grid[x-1][y] == 1) return ans;
                if (x < n-1 && grid[x+1][y] == 1) return ans;
                if (y > 0 && grid[x][y-1] == 1) return ans;
                if (y < n-1 && grid[x][y+1] == 1) return ans;
                if (x > 0 && grid[x-1][y] == 0) {
                    grid[x-1][y] = 2;
                    q.push({x-1, y});
                }
                if (x < n-1 && grid[x+1][y] == 0) {
                    grid[x+1][y] = 2;
                    q.push({x+1, y});
                }
                if (y > 0 && grid[x][y-1] == 0) {
                    grid[x][y-1] = 2;
                    q.push({x, y-1});
                }
                if (y < n-1 && grid[x][y+1] == 0) {
                    grid[x][y+1] = 2;
                    q.push({x, y+1});
                }
            }
            ++ans;
        }
        return ans;
    }
};