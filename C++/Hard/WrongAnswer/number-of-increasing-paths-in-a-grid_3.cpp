class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int mod = 1e9 + 7;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        vector<vector<int>> dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] > grid[i][j]){
                        dp[i][j] = (dp[i][j] + dp[x][y]) % mod;
                    }
                }
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = (ans + dp[i][j]) % mod;
            }
        }
        return ans;
    }
};