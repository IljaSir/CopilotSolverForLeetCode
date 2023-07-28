class Solution {
public:
    int minStickers(vector<string>& stickers, string target) {
        
        int n = stickers.size();
        vector<vector<int>> cnt(n, vector<int>(26, 0));
        for (int i = 0; i < n; ++i) {
            for (char c : stickers[i]) {
                ++cnt[i][c - 'a'];
            }
        }
        int m = target.size();
        vector<vector<int>> dp(1 << m, vector<int>(26, 0));
        for (int i = 0; i < (1 << m); ++i) {
            for (int j = 0; j < m; ++j) {
                if ((i >> j) & 1) {
                    ++dp[i][target[j] - 'a'];
                }
            }
        }
        for (int i = 0; i < (1 << m); ++i) {
            for (int j = 0; j < n; ++j) {
                int nxt = i;
                for (int k = 0; k < 26; ++k) {
                    if (dp[i][k] < cnt[j][k]) {
                        nxt |= ((1 << m) - 1) ^ ((1 << (m - dp[i][k])) - 1);
                    }
                }
                if (nxt != i) {
                    for (int k = 0; k < 26; ++k) {
                        dp[nxt][k] = max(dp[nxt][k], dp[i][k] - cnt[j][k]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            ans += dp[(1 << m) - 1][target[i] - 'a'];
        }
        return ans == m ? -1 : ans;
    }
};