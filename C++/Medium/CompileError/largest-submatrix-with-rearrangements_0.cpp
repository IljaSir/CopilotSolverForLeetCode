class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        
        for (int i = 1; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[0].size(); ++j) {
                if (matrix[i][j]) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.size(); ++i) {
            sort(matrix[i].begin(), matrix[i].end());
            for (int j = 0; j < matrix[0].size(); ++j) {
                res = max(res, matrix[i][j] * (matrix[0].size() - j));
            }
        }
        return res;
    }
};