class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        vector<int> rowMax(m, 0);
        vector<int> colMax(n, 0);
        vector<vector<pair<int, int>>> pos(50001);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos[matrix[i][j]].push_back({i, j});
            }
        }
        for (int i = 1; i < 50001; i++) {
            vector<int> rowRank(m, 0);
            vector<int> colRank(n, 0);
            for (auto p : pos[i]) {
                int r = p.first;
                int c = p.second;
                res[r][c] = max(rowRank[r], colRank[c]) + 1;
                rowRank[r] = res[r][c];
                colRank[c] = res[r][c];
            }
        }
        return res;
    }
};