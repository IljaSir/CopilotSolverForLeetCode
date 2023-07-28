class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        
        vector<vector<int>> result(n, vector<int>(n, 0));
        for (auto query : queries) {
            int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    result[i][j] += 1;
                }
            }
        }
        return result;
    }
};