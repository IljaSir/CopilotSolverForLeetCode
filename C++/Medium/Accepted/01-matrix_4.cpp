class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> ans(m, vector<int>(n, INT_MAX));
        queue<pair<int, int>> q;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.push({i, j});
                }
            }
        }
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x > 0 && ans[x - 1][y] == INT_MAX) {
                ans[x - 1][y] = ans[x][y] + 1;
                q.push({x - 1, y});
            }
            if (x < m - 1 && ans[x + 1][y] == INT_MAX) {
                ans[x + 1][y] = ans[x][y] + 1;
                q.push({x + 1, y});
            }
            if (y > 0 && ans[x][y - 1] == INT_MAX) {
                ans[x][y - 1] = ans[x][y] + 1;
                q.push({x, y - 1});
            }
            if (y < n - 1 && ans[x][y + 1] == INT_MAX) {
                ans[x][y + 1] = ans[x][y] + 1;
                q.push({x, y + 1});
            }
        }
        return ans;
    }
};