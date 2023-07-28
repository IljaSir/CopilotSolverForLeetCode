class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        vector<vector<int>> row(m, vector<int>());
        vector<vector<int>> col(n, vector<int>());
        vector<int> maxRow(m, 0);
        vector<int> maxCol(n, 0);
        vector<vector<pair<int,int>>> v(m*n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v[i*n+j] = {{matrix[i][j], i}, {matrix[i][j], j}};
            }
        }
        sort(v.begin(), v.end());
        for (int i = 0; i < m*n; i++) {
            int r = v[i][0].second;
            int c = v[i][1].second;
            res[r][c] = max(maxRow[r], maxCol[c]) + 1;
            maxRow[r] = maxCol[c] = res[r][c];
            for (int j = 0; j < row[r].size(); j++) {
                int c2 = row[r][j];
                maxCol[c2] = max(maxCol[c2], res[r][c]);
            }
            for (int j = 0; j < col[c].size(); j++) {
                int r2 = col[c][j];
                maxRow[r2] = max(maxRow[r2], res[r][c]);
            }
            row[r].push_back(c);
            col[c].push_back(r);
        }
        return res;
    }
};