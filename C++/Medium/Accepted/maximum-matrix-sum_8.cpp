class Solution {
public:
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        int count = 0;
        long long sum = 0;
        int min = 100000;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] < 0) {
                    count++;
                }
                sum += abs(matrix[i][j]);
                min = std::min(min, abs(matrix[i][j]));
            }
        }
        if(count % 2 == 0) {
            return sum;
        }
        return sum - 2 * min;
    }
};