class Solution {
public:
    string longestSubsequenceRepeatedK(string s, int k) {
        
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1));
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                dp[i][j] = max(dp[i + 1][j], dp[i][j + 1]);
                if (s[i] == s[j]) {
                    int l = 1;
                    for (int x = i + 1, y = j + 1; x < n && y < n; ++x, ++y) {
                        if (s[x] == s[y]) {
                            ++l;
                        }
                    }
                    if (l >= k) {
                        dp[i][j] = max(dp[i][j], k + dp[i + k][j + k]);
                    }
                }
            }
        }
        string ans;
        for (int i = 0, j = 0; i < n && j < n;) {
            if (dp[i][j] == dp[i + 1][j]) {
                ++i;
            } else if (dp[i][j] == dp[i][j + 1]) {
                ++j;
            } else {
                ans.push_back(s[i]);
                i += k;
                j += k;
            }
        }
        return ans;
    }
};