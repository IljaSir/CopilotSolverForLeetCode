class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        
        vector<vector<int>> res;
        if (m * n != original.size()) {
            return res;
        }
        int i = 0;
        for (int j = 0; j < m; j++) {
            vector<int> row;
            for (int k = 0; k < n; k++) {
                row.push_back(original[i++]);
            }
            res.push_back(row);
        }
        return res;
    }
};