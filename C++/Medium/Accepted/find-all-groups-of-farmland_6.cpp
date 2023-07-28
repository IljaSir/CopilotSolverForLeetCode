class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        
        vector<vector<int>> result;
        int m = land.size();
        int n = land[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (land[i][j] == 1) {
                    int x = i, y = j;
                    while (y < n && land[x][y] == 1) {
                        ++y;
                    }
                    while (x < m && land[x][j] == 1) {
                        ++x;
                    }
                    result.push_back({i, j, x - 1, y - 1});
                    for (int k = i; k < x; ++k) {
                        for (int l = j; l < y; ++l) {
                            land[k][l] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }
};