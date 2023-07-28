class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        
        vector<vector<int>> res(n, vector<int>(n, 0));
        for (auto& q : queries) {
            int x1 = q[0], y1 = q[1], x2 = q[2], y2 = q[3];
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    res[i][j]++;
                }
            }
        }
        return res;
    }
};