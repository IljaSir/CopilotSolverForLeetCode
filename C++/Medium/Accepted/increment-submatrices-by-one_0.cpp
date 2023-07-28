class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        
        vector<vector<int>> res(n, vector<int>(n, 0));
        for (auto& q : queries) {
            res[q[0]][q[1]]++;
            if (q[2] + 1 < n) res[q[2] + 1][q[1]]--;
            if (q[3] + 1 < n) res[q[0]][q[3] + 1]--;
            if (q[2] + 1 < n && q[3] + 1 < n) res[q[2] + 1][q[3] + 1]++;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) res[i][j] += res[i - 1][j];
                if (j > 0) res[i][j] += res[i][j - 1];
                if (i > 0 && j > 0) res[i][j] -= res[i - 1][j - 1];
            }
        }
        return res;
    }
};