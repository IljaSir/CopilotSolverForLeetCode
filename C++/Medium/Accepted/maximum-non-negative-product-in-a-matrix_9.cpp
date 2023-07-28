class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        long long maxdp[m][n];
        long long mindp[m][n];
        long long mod = 1e9 + 7;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxdp[i][j] = INT_MIN;
                mindp[i][j] = INT_MAX;
            }
        }
        maxdp[0][0] = grid[0][0];
        mindp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            maxdp[i][0] = maxdp[i-1][0] * grid[i][0];
            mindp[i][0] = mindp[i-1][0] * grid[i][0];
        }
        for(int i = 1; i < n; i++){
            maxdp[0][i] = maxdp[0][i-1] * grid[0][i];
            mindp[0][i] = mindp[0][i-1] * grid[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] > 0){
                    maxdp[i][j] = max(maxdp[i-1][j], maxdp[i][j-1]) * grid[i][j];
                    mindp[i][j] = min(mindp[i-1][j], mindp[i][j-1]) * grid[i][j];
                }else{
                    maxdp[i][j] = min(mindp[i-1][j], mindp[i][j-1]) * grid[i][j];
                    mindp[i][j] = max(maxdp[i-1][j], maxdp[i][j-1]) * grid[i][j];
                }
            }
        }
        long long ans = maxdp[m-1][n-1];
        if(ans < 0) return -1;
        return ans % mod;
    }
};