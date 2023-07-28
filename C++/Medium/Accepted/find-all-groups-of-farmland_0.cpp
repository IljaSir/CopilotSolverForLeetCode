class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        
        int m = land.size();
        int n = land[0].size();
        vector<vector<int>> res;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (land[i][j] == 1) {
                    int x = i, y = j;
                    while (x < m && land[x][j] == 1) {
                        ++x;
                    }
                    while (y < n && land[i][y] == 1) {
                        ++y;
                    }
                    res.push_back({i, j, x - 1, y - 1});
                    for (int a = i; a < x; ++a) {
                        for (int b = j; b < y; ++b) {
                            land[a][b] = 0;
                        }
                    }
                }
            }
        }
        return res;
    }
};