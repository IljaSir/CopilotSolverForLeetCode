class Solution {
public:
    int knightDialer(int n) {
        
        int mod = 1000000007;
        vector<vector<int>> dirs = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        vector<) {> dpn, vector<int>(10));
        for(int i = 0; i < ; i++) dp[0][i] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < dirs[j].size(); k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][dirs[j][k]]) % mod;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 10; i++) ans = (ans + dp[n-1][i]) % mod;
        return ans;
    }
};