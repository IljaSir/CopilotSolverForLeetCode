class Solution {
public:
    string shortestSuperstring(vector<string>& words) {
        
        int n = words.size();
        vector<vector<string>> dp(n, vector<string>(n, ""));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                string w1 = words[i], w2 = words[j];
                int len = min(w1.size(), w2.size());
                for (int k = len; k >= 0; --k) {
                    if (w1.substr(w1.size() - k) == w2.substr(0, k)) {
                        dp[i][j] = w2.substr(k);
                        break;
                    }
                }
            }
        }
        vector<vector<string>> dp2(1 << n, vector<string>(n, ""));
        for (int i = 0; i < n; ++i) {
            dp2[1 << i][i] = words[i];
        }
        for (int i = 0; i < (1 << n); ++i) {
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) continue;
                for (int k = 0; k < n; ++k) {
                    if (i & (1 << k)) continue;
                    string s = dp2[i][j] + dp[j][k];
                    if (dp2[i | (1 << k)][k] == "" || dp2[i | (1 << k)][k].size() > s.size()) {
                        dp2[i | (1 << k)][k] = s;
                    }
                }
            }
        }
        int minLen = INT_MAX, minIdx = 0;
        for (int i = 0; i < n; ++i) {
            if (minLen > dp2[(1 << n) - 1][i].size()) {
                minLen = dp2[(1 << n) - 1][i].size();
                minIdx = i;
            }
        }
        return dp2[(1 << n) - 1][minIdx];
    }
};