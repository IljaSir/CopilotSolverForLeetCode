class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        
        vector<vector<int>> result;
        int m = land.size(), n = land[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int right = j;
                    while (right < n && land[i][right] == 1) {
                        right++;
                    }
                    int down = i;
                    while (down < m && land[down][j] == 1) {
                        down++;
                    }
                    result.push_back({i, j, down - 1, right - 1});
                    for (int k = i; k < down; k++) {
                        for (int l = j; l < right; l++) {
                            land[k][l] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }
};