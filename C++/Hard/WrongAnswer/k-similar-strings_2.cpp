class Solution {
public:
    int kSimilarity(string s1, string s2) {
        
        int n = s1.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = (s1[i] == s2[j]);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                if (dp[i][j]) {
                    for (int k = 0; k < n; ++k) {
                        if (k == i || k == j) {
                            continue;
                        }
                        dp[i][k] = max(dp[i][k], dp[j][k]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                if (dp[i][j]) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
};