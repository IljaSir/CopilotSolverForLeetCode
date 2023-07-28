class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        vector<bool> rows(n, false), cols(n, false);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!rows[i] || !cols[i]) {
                return false;
            }
        }
        return true;
    }
};