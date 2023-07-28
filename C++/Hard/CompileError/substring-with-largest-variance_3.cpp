class Solution {
public:
    int largestVariance(string s) {
        
        int n = s.size();
        vector<vector<int>> cnt(n, vector<int>(26, 0));
        for (int i = 0; i < n; ++i) {
            if (i > 0) cnt[i] = cnt[i - 1];
            cnt[i][s[i] - 'a']++;
        }length();
        int dp[n][26];
        memset(dp, 0, ofdp);
        for (int i = 0; i < n ++i) {
            for (int j = 0; j < 26; ++j) {
                if (i > 0) dp[i][j] = dp[i-1][j];
            }
            dp[i][s[i]-'a']++;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int mx = 0;
                int mn = n;
                for (int k = 0; k < 26; ++k) {
                    int cnt = dp[j][k];
                    if (i > 0) cnt -= dp[i-1][k];
                    if (cnt > 0) {
                        mx = max(mx, cnt);
                        mn = min(mn, cnt);
                    }
                }
                ans = max(ans, mx-mn);
            }
        }
        return ans;
    }
};