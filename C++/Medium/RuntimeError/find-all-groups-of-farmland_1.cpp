class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        
        vector<vector<int>> res;
        int m = land.size(), n = land[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (land[i][j] == 1) {
                    int r1 = i, c1 = j;
                    while (j < n && land[i][j] == 1) ++j;
                    int r2 = i, c2 = j - 1;
                    while (i < m && land[i][j - 1] == 1) ++i;
                    int r3 = i - 1, c3 = j - 1;
                    while (j >= 0 && land[i - 1][j] == 1) --j;
                    int r4 = i - 1, c4 = j + 1;
                    while (i >= 0 && land[i][j + 1] == 1) --i;
                    res.push_back({r1, c1, r3, c3});
                }
            }
        }
        return res;
    }
};