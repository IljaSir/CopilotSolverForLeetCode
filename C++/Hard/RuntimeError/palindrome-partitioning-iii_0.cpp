class Solution {
public:
    int palindromePartition(string s, int k) {
        
        int n = s.length();
        vector<vector<int>> cost(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int l = i, r = j;
                while (l < r) {
                    cost[i][j] += s[l] != s[r];
                    ++l, --r;
                }
            }
        }
        
        vector<vector<int>> dp(n, vector<int>(k + 1, n));
        for (int i = 0; i < n; ++i) {
            dp[i][1] = cost[0][i];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 2; j <= k; ++j) {
                for (int p = i; p >= 0; --p) {
                    dp[i][j] = min(dp[i][j], dp[p][j - 1] + cost[p + 1][i]);
                }
            }
        }
        return dp[n - 1][k];
    }
};