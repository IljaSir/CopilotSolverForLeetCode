class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        
        vector<vector<int>> ans;
        for (int i = 0; i < land.size(); i++) {
            for (int j = 0; j < land[i].size(); j++) {
                if (land[i][j] == 1) {
                    int r = i, c = j;
                    while (r < land.size() && land[r][j] == 1) {
                        r++;
                    }
                    while (c < land[i].size() && land[i][c] == 1) {
                        c++;
                    }
                    ans.push_back({i, j, r - 1, c - 1});
                    for (int x = i; x < r; x++) {
                        for (int y = j; y < c; y++) {
                            land[x][y] = 0;
                        }
                    }
                }
            }
        }
        return ans;
    }
};