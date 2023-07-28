class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        long long sum = 0;
        int n = matrix.size();
        int minv = INT_MAX;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += abs(matrix[i][j]);
                minv = min(minv, abs(matrix[i][j]));
                if (matrix[i][j] < 0) cnt++;
            }
        }
        if (cnt % 2 != 0) sum -= 2 * minv;
        return sum;
    }
};