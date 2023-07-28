class Solution {
public:
    vector<vector<int>> matrixRankTransform(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        vector<vector<int>> sorted(m * n);
        vector<int> rank(n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sorted[i * n + j] = {matrix[i][j], i, j};
            }
        }
        sort(sorted.begin(), sorted.end());
        for (int i = 0; i < m; i++) {
            vector<int> tmp(n, 0);
            for (int j = 0; j < n; j++) {
                tmp[j] = rank[j];
            }
            for (int j = 0; j < n; j++) {
                rank[j] = max(rank[j], tmp[j]);
            }
            int last = -1;
            for (int j = 0; j < n; j++) {
                if (last != -1 && matrix[i][j] != matrix[i][last]) {
                    for (int k = last; k < j; k++) {
                        rank[k] = max(rank[k], rank[j]);
                    }
                    last = j;
                }
                else if (last == -1) {
                    last = j;
                }
            }
            if (last != -1) {
                for (int k = last; k < n; k++) {
                    rank[k] = max(rank[k], rank[last]);
                }
            }
            for (int j = 0; j < n; j++) {
                res[i][j] = rank[j];
            }
        }
        for (int j = 0; j < n; j++) {
            rank[j] = 0;
        }
        for (int j = 0; j < n; j++) {
            vector<int> tmp(m, 0);
            for (int i = 0; i < m; i++) {
                tmp[i] = rank[i];
            }
            for (int i = 0; i < m; i++) {
                rank[i] = max(rank[i], tmp[i]);
            }
            int last = -1;
            for (int i = 0; i < m; i++) {
                if
    }
};