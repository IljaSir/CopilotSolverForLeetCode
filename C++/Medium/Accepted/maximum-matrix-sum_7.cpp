class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        int neg = 0;
        int zeros = 0;
        long long sum = 0;
        int min_abs = INT_MAX;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    neg++;
                }
                if (matrix[i][j] == 0) {
                    zeros++;
                }
                min_abs = min(min_abs, abs(matrix[i][j]));
                sum += abs(matrix[i][j]);
            }
        }
        if (zeros > 0) {
            return sum;
        }
        if (neg % 2 == 0) {
            return sum;
        }
        return sum - 2 * min_abs;
    }
};