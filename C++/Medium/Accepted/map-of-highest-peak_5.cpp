class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        
        int m = isWater.size();
        int n = isWater[0].size();
        vector<vector<int>> ans(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        vector<vector<int>> d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    q.push({i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            for (int i = 0; i < 4; ++i) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || ans[nx][ny] != -1) {
                    continue;
                }
                ans[nx][ny] = ans[x][y] + 1;
                q.push({nx, ny});
            }
        }
        return ans;
    }
};