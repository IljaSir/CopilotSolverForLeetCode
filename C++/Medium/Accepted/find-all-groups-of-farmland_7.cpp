class Solution {
public:
    vector<vector<int>> findFarmland(vector<vector<int>>& land) {
        
        int m = land.size();
        int n = land[0].size();
        vector<vector<int>> res;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1){
                    int r = i, c = j;
                    while(r < m && land[r][j] == 1) r++;
                    while(c < n && land[i][c] == 1) c++;
                    for(int k = i; k < r; k++){
                        for(int l = j; l < c; l++){
                            land[k][l] = 0;
                        }
                    }
                    res.push_back({i, j, r - 1, c - 1});
                }
            }
        }
        return res;
    }
};