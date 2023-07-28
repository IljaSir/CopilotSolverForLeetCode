class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        long long sum = 0;
        int min_abs = INT_MAX;
        int neg_cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = abs(matrix[i][j]);
                min_abs = min(min_abs, x);
                sum += x;
                if (matrix[i][j] < 0) {
                    neg_cnt++;
                }
            }
        }
        if (neg_cnt % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min_abs;
        }
    }
};