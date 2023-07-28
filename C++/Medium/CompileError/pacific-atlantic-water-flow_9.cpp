class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        
        int m = heights.size();
        int n = heights[0].size();
        queue<pair<int, int>> q;
        vector<vector<int>> visted(m, vector<int>(n, 0));
        vector<vector<int>> result;
        for (int i = 0; i < m; i++) {
            q.push({i, 0});
            visted[i][0] |= 1;
            q.push({i, n - 1});
            visted[i][n - 1] |= 2;
        }
        for (int i = 0; i < n; i++) {
            q.push({0, i});
            visted[0][i] |= 1;
            q.push({m - 1, i});
            visted[m - 1][i] |= 2;
        }
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || heights[nx][ny] < heights[x][y]) continue;
                if (visted[nx][ny] == 3) continue;
                if (visted[nx][ny] == 0) {
                    q.push({nx, ny});
                }
                visted[nx][ny] |= visted[x][y];
                if (visted[nx][ny] == 3) {
                    result.push_back({nx, ny});
                }
            }
        }
        return result;
    }
};