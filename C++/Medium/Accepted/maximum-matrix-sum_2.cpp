class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        long long sum = 0;
        int n = matrix.size();
        int min = INT_MAX;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += abs(matrix[i][j]);
                if (matrix[i][j] < 0) {
                    count++;
                }
                if (abs(matrix[i][j]) < min) {
                    min = abs(matrix[i][j]);
                }
            }
        }
        if (count % 2 == 1) {
            sum -= 2 * min;
        }
        return sum;
    }
};