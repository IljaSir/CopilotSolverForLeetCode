class Solution {
public:
    vector<int> luckyNumbers (vector<vector<int>>& matrix) {
        
        vector<int> rows(matrix.size(), INT_MAX);
        vector<int> cols(matrix[0].size(), INT_MIN);
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[i].size(); j++) {
                rows[i] = min(rows[i], matrix[i][j]);
                cols[j] = max(cols[j], matrix[i][j]);
            }
        }
        vector<int> res;
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < cols.size(); j++) {
                if (rows[i] == cols[j]) {
                    res.push_back(rows[i]);
                }
            }
        }
        return res;
    }
};