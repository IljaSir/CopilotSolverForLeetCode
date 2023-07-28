class Solution {
public:
    int maximumMinutes(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int ans = 0;
        vector<pair<int, int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        queue<pair<int, int>> q;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q.emplace(i, j);
                }
            }
        }
        while (!q.empty()) {
            bool hasFire = false;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto [x, y] = q.front();
                q.pop();
                for (auto& dir : dirs) {
                    int nx = x + dir.first, ny = y + dir.second;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        hasFire = true;
                        q.emplace(nx, ny);
                    }
                }
            }
            if (hasFire) {
                ++ans;
            }
        }
        return ans == 0 ? -1 : ans;
    }
};