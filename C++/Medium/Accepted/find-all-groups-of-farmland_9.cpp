class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        
        int m = land.size();
        int n = land[0].size();
        vector<vector<int>> res;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(land[i][j] == 1) {
                    int r1 = i, c1 = j;
                    int r2 = i, c2 = j;
                    while(r2 < m && land[r2][j] == 1) {
                        ++r2;
                    }
                    while(c2 < n && land[i][c2] == 1) {
                        ++c2;
                    }
                    for(int r = r1; r < r2; ++r) {
                        for(int c = c1; c < c2; ++c) {
                            land[r][c] = 0;
                        }
                    }
                    res.push_back({r1, c1, r2 - 1, c2 - 1});
                }
            }
        }
        return res;
    }
};