class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> ans(m, vector<int>(n));
        vector<int> row(m), col(n);
        vector<vector<pair<int, int>>> v(m + n);
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                v[i].emplace_back(matrix[i][j], j);
        for (int i = 0; i < m + n; ++i)
            sort(v[i].begin(), v[i].end());
        for (int i = 0; i < m + n; ++i) {
            vector<int> rank(n + m, 0);
            for (int j = 0; j < v[i].size(); ++j) {
                int x = v[i][j].second;
                if (x >= m) x -= m;
                else x += n;
                rank[x] = max(rank[x], rank[i] + 1);
            }
            for (int j = 0; j < v[i].size(); ++j) {
                int x = v[i][j].second;
                if (x >= m) {
                    x -= m;
                    ans[x][i - m] = rank[i];
                    col[i - m] = max(col[i - m], rank[i]);
                }
                else {
                    ans[i][x] = rank[i];
                    row[i] = max(row[i], rank[i]);
                }
            }
        }
        return ans;
    }
};