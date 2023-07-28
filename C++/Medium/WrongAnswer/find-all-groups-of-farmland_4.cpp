class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        
        vector<vector<int>> result;
        int m = land.size();
        int n = land[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    vector<int> temp;
                    temp.push_back(i);
                    temp.push_back(j);
                    int x = j;
                    while (x < n && land[i][x] == 1) {
                        x++;
                    }
                    temp.push_back(i);
                    temp.push_back(x - 1);
                    int y = i;
                    while (y < m && land[y][j] == 1) {
                        y++;
                    }
                    temp.push_back(y - 1);
                    temp.push_back(x - 1);
                    result.push_back(temp);
                    for (int k = i; k < y; k++) {
                        for (int l = j; l < x; l++) {
                            land[k][l] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }
};