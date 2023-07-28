class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        
        vector<vector<int>> mat(n, vector<int>(n, 0));
        for (auto& query : queries) {
            for (int row = query[0]; row <= query[2]; ++row) {
                for (int col = query[1]; col <= query[3]; ++col) {
                    ++mat[row][col];
                }
            }
        }
        return mat;
    }
};