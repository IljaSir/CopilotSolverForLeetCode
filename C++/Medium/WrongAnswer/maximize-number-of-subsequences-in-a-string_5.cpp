class Solution {
public:
    long long maximumSubsequenceCount(string text, string pattern) {
        
        int n = text.size();
        int m = pattern.size();
        vector<int> pos[26];
        for (int i = 0; i < n; i++) {
            pos[text[i] - 'a'].push_back(i);
        }
        vector<int> dp(n + 1);
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            int c = pattern[i] - 'a';
            if (pos[c].empty()) {
                return 0;
            }
            vector<int> ndp(n + 1);
            for (int j = 0; j < n; j++) {
                ndp[j + 1] = (ndp[j] + dp[j + 1]) % 1000000007;
            }
            for (int j = 0; j < n; j++) {
                int p = lower_bound(pos[c].begin(), pos[c].end(), j) - pos[c].begin();
                if (p < pos[c].size()) {
                    ndp[pos[c][p] + 1] = (ndp[pos[c][p] + 1] - dp[j + 1] + 1000000007) % 1000000007;
                }
            }
            dp = ndp;
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = (ans + dp[i]) % 1000000007;
        }
        return ans;
    }
};