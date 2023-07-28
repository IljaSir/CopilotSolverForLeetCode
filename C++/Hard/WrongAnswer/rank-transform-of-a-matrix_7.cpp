class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> ans(m, vector<int>(n));
        vector<vector<int>> pos(m + n);
        vector<int> rank(m + n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                pos[i].push_back(j);
                pos[m + j].push_back(i);
            }
        }
        auto cmp = [&](int i, int j) { return matrix[i / n][i % n] < matrix[j / n][j % n]; };
        for (int i = 0; i < m + n; ++i) {
            sort(pos[i].begin(), pos[i].end(), cmp);
            for (int j = 0; j < pos[i].size(); ++j) {
                if (j == 0 || matrix[i / n][i % n] != matrix[pos[i][j] / n][pos[i][j] % n]) {
                    rank[i] = j + 1;
                }
                ans[pos[i][j] / n][pos[i][j] % n] = rank[i];
            }
        }
        return ans;
    }
};