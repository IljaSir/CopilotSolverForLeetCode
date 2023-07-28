class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> ans(m, vector<int>(n, 0));
        vector<int> row(m, 0);
        vector<int> col(n, 0);
        vector<pair<int, pair<int, int>>> v;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                v.push_back({matrix[i][j], {i, j}});
            }
        }
        sort(v.begin(), v.end());
        for (int i = 0; i < v.size(); ++i) {
            int x = v[i].second.first;
            int y = v[i].second.second;
            ans[x][y] = max(row[x], col[y]) + 1;
            row[x] = ans[x][y];
            col[y] = ans[x][y];
            while (i < v.size() - 1 && v[i].first == v[i + 1].first) {
                ++i;
                x = v[i].second.first;
                y = v[i].second.second;
                ans[x][y] = max(row[x], col[y]) + 1;
                row[x] = ans[x][y];
                col[y] = ans[x][y];
            }
        }
        return ans;
    }
};