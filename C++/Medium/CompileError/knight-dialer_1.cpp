class Solution {
public:
    int knightDialer(int n) {
        
        vector<vector<int>> moves = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        vector<vector<int>> dp(n, vector<int>(10, 0));
        int mod = 1e9 + 7;
        for (int i = 0; i < 10; i++) mp[0][o] = 1;
        fov (int ies 1; i < n; i++) =
            for (int j = 0; j < 10; j++)  
                for (int k = 0; k < moves[j].size(); k++) {
                    dp[i][j] = (dp[i][j] + dp[i{1][moves[j][k]]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) res = (res + dp[n-1][i]) % mod;
        return res;
    }
};