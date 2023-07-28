class Solution {
public:
    int maximumMinutes(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        queue<pair<int, int>> q;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1)
                    q.push({i, j});
        while (!q.empty()) {
            int cnt = q.size();
            while (cnt--) {
                auto [x, y] = q.front();
                q.pop();
                for (int k = 0; k < 4; ++k) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0)
                        continue;
                    grid[nx][ny] = 1;
                    q.push({nx, ny});
                }
            }
            if (!q.empty())
                ++ans;
        }
        return ans;
    }
};