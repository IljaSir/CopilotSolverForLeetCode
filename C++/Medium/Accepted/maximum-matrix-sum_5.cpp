class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        int min = INT_MAX;
        long long sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] < 0) {
                    ++cnt;
                }
                if (abs(matrix[i][j]) < min) {
                    min = abs(matrix[i][j]);
                }
                sum += abs(matrix[i][j]);
            }
        }
        if (cnt % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min;
        }
    }
};