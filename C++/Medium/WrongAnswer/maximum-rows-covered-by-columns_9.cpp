class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int max = 0;
        vector<int> rows(m, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += matrix[i][j];
            }
        }
        for (int i = 0; i < pow(2, n); i++) {
            int count = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    count++;
                    for (int k = 0; k < m; k++) {
                        sum += matrix[k][j];
                    }
                }
            }
            if (count == numSelect && sum > max) {
                max = sum;
            }
        }
        return max;
    }
};