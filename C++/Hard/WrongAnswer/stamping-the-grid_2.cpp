class Solution {
public:
    bool possibleToStamp(vector<vector<int>>& grid, int stampHeight, int stampWidth) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> vis(m, vector<int>(n, 0));
        vector<vector<int>> dir{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int cnt = 0;
        bool flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(vis[i][j]) continue;
                    int k = 0;
                    while(k < stampHeight && i + k < m){
                        int l = 0;
                        while(l < stampWidth && j + l < n && (grid[i + k][j + l] == 1 || vis[i + k][j + l] == 1)){
                            l++;
                        }
                        if(l < stampWidth) break;
                        k++;
                    }
                    if(k == stampHeight){
                        flag = true;
                        for(int x = 0; x < stampHeight; x++){
                            for(int y = 0; y < stampWidth; y++){
                                vis[i + x][j + y] = 1;
                                if(grid[i + x][j + y] == 0) cnt++;
                            }
                        }
                    }
                }
            }
        }
        return cnt == m * n;
    }
};