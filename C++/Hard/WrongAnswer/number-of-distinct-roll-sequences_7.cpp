class Solution {
public:
    int distinctSequences(int n) {
        
        if (n == 1) return 6;
        if (n == 2) return 22;
        vector<vector<int>> dp(n + 1, vector<int>(6, 0));
        for (int i = 0; i < 6; i++) dp[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j != k && abs(j - k) > 1) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            res += dp[n][i];
            res %= 1000000007;
        }
        return res;
    }
};