class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> res(m, vector<int>(n));
        vector<int> row(m, 0), col(n, 0);
        vector<vector<pair<int, int>>> vals(100001);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                vals[matrix[i][j]].push_back({i, j});
            }
        }
        for (auto& p : vals) {
            vector<int> rank(m + n, 0);
            for (auto& v : p) {
                rank[v.first] = rank[m + v.second] = max(rank[v.first], rank[m + v.second]);
            }
            for (auto& v : p) {
                rank[v.first] = rank[m + v.second] = res[v.first][v.second] = max(rank[v.first], rank[m + v.second]) + 1;
            }
        }
        return res;
    }
};