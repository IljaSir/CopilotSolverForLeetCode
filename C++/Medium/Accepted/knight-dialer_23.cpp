class Solution {
public:
    int knightDialer(int n) {
        
        vector<vector<int>> dp(n, vector<int>(10, 0));
        vector<vector<int>> moves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        for (int i = 0; i < 10; i++)
            dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < moves[j].size(); k++) {
                    dp[i][j] += dp[i - 1][moves[j][k]];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[n - 1][i];
            res %= 1000000007;
        }
        return res;
    }
};