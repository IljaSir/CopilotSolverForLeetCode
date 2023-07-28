class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        
        int row = matrix.size();
        int col = matrix[0].size();
        vector<int> v(col, 0);
        int ans = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 1) {
                    v[j] += 1;
                } else {
                    v[j] = 0;
                }
            }
            sort(v.begin(), v.end());
            for (int j = 0; j < col; ++j) {
                ans = max(ans, v[j] * (col - j));
            }
        }
        return ans;
    }
};