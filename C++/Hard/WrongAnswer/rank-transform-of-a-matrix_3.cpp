class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        vector<int> rowMax(m, 0), colMax(n, 0);
        vector<pair<int, int>> order;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                order.push_back({matrix[i][j], i * n + j});
            }
        }
        sort(order.begin(), order.end());
        for (auto& p : order) {
            int i = p.second / n, j = p.second % n;
            res[i][j] = max(rowMax[i], colMax[j]) + 1;
            rowMax[i] = colMax[j] = res[i][j];
        }
        return res;
    }
};