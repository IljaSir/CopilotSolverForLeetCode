class Solution {
public:
    int findGoodStrings(int n, string s1, string s2, string evil) {
        
        int len = evil.size();
        vector<int> next(len, 0);
        for (int i = 1, j = 0; i < len; ++i) {
            while (j > 0 && evil[i] != evil[j]) {
                j = next[j - 1];
            }
            if (evil[i] == evil[j]) {
                ++j;
            }
            next[i] = j;
        }

        vector<vector<int>> dp(n + 1, vector<int>(len, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < len; ++j) {
                int k = j;
                while (k > 0 && evil[k] != s1[i - 1]) {
                    k = next[k - 1];
                }
                if (evil[k] == s1[i - 1]) {
                    ++k;
                }
                dp[i][k] = (dp[i][k] + dp[i - 1][j]) % 1000000007;
            }

            for (int j = 0; j < len; ++j) {
                int k = j;
                while (k > 0 && evil[k] != s2[i - 1]) {
                    k = next[k - 1];
                }
                if (evil[k] == s2[i - 1]) {
                    ++k;
                }
                dp[i][k] = (dp[i][k] - dp[i - 1][j] + 1000000007) % 1000000007;
            }

            for (int j = 1; j < len; ++j) {
                dp[i][j] = (dp[i][j] + dp[i][j - 1]) % 1000000007;
            }
        }

        int res = 0;
        for (int i = 0; i < len; ++i) {
            res = (res + dp[n][i]) % 1000000007;
        }
        return res;
    }
};