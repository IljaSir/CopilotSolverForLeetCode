class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        vector<int> rows(m, 0);
        vector<int> cols(n, 0);
        vector<pair<int, pair<int, int>>> v;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                v.push_back({matrix[i][j], {i, j}});
            }
        }
        sort(v.begin(), v.end());
        for (int i = 0; i < v.size(); ++i) {
            int r = v[i].second.first;
            int c = v[i].second.second;
            int rank = max(rows[r], cols[c]) + 1;
            res[r][c] = rank;
            rows[r] = rank;
            cols[c] = rank;
        }
        return res;
    }
};