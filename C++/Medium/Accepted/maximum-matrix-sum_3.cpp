class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        long long sum = 0;
        int min = INT_MAX;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += abs(matrix[i][j]);
                if (matrix[i][j] < 0) neg++;
                if (abs(matrix[i][j]) < min) min = abs(matrix[i][j]);
            }
        }
        if (neg % 2 == 0) return sum;
        return sum - 2 * min;
    }
};