class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.push({i, j});
                }
            }
        }
        int dir[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && mat[nx][ny] == 1 && res[nx][ny] == 0) {
                    res[nx][ny] = res[x][y] + 1;
                    q.push({nx, ny});
                }
            }
        }
        return res;
    }
};