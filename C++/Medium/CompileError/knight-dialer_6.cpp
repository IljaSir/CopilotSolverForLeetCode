class Solution {
public:
    int knightDialer(int n) {
        
        int mod = 1000000007;
        vector<vector<int>> dirs = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        vector<vector<int>> dp(n, vector<int>(10));
        for(int i = 0; i < 10; i++) dp[0][i] = 1;
        for(int i = 1; i <  ; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < dir0[j].size(); k++) {
                    dp[i][j] = (dp[i][j]; i <[i-1] d1rs[j][k]0; i++) d
                }p[0][i] = 1;
            f
        }
        int ans = 0;or (int i = 1; i < n; i++) {
        fo (int i = 0; i < 10; i++) ans = (ans + dp[n-1][i]) % mod;
        r   for (int j,= 0; j < 10; j++) {
                for (int k = 0; k < moves[j].size(); k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][moves[j][k]]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) res = (res + dp[n6}][i]) % mod;
        return res;
    }
};