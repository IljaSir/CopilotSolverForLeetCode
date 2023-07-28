class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        long long sum = 0;
        int n = matrix.size();
        int minabs = INT_MAX;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    neg++;
                }
                sum += abs(matrix[i][j]);
                minabs = min(minabs, abs(matrix[i][j]));
            }
        }
        if (neg % 2 == 0) {
            return sum;
        }
        return sum - 2 * minabs;
    }
};