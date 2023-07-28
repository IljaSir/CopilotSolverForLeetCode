class Solution {
public:
    int knightDialer(int n) {
        
        if (n == 1) return 10;
        int mod = 1000000007;
        vector<vector<int>> dp(4, vector<int>(3, 1));
        dp[3][0] = dp[3][2] = 0;
        for (int i = 1; i < n; i++) {
            vector<vector<int>> temp(4, vector<int>(3, 0));
            temp[0][0] = (dp[0][1] + dp[1][0]) % mod;
            temp[0][1] = (dp[0][0] + dp[0][2] + dp[1][1]) % mod;
            temp[0][2] = (dp[0][1] + dp[1][2]) % mod;
            temp[1][0] = (dp[0][0] + dp[2][0] + dp[1][1]) % mod;
            temp[1][1] = (dp[0][1] + dp[1][0] + dp[1][2] + dp[2][1]) % mod;
            temp[1][2] = (dp[0][2] + dp[1][1] + dp[2][2]) % mod;
            temp[2][0] = (dp[1][0] + dp[2][1] + dp[3][0]) % mod;
            temp[2][1] = (dp[2][0] + dp[2][2] + dp[3][1]) % mod;
            temp[2][2] = (dp[2][1] + dp[3][2]) % mod;
            temp[3][0] = (dp[2][0] + dp[3][1]) % mod;
            temp[3][1] = (dp[3][0] + dp[3][2]) % mod;
            temp[3][2] = (dp[3][1] + dp[2][2]) % mod;
            dp = temp;
        }
        int res = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++)
                res = (res + dp[i][j]) % mod;
    }
};