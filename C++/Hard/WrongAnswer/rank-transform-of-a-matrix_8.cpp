class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> ans(m, vector<int>(n, 0));
        vector<vector<pair<int, int>>> pos(10001);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos[matrix[i][j]].push_back({i, j});
            }
        }
        vector<int> row(m, 0);
        vector<int> col(n, 0);
        for (int v = 0; v <= 10000; v++) {
            vector<int> row(m, 0);
            vector<int> col(n, 0);
            for (auto& p: pos[v]) {
                int i = p.first;
                int j = p.second;
                ans[i][j] = max(row[i], col[j]) + 1;
                row[i] = ans[i][j];
                col[j] = ans[i][j];
            }
        }
        return ans;
    }
};