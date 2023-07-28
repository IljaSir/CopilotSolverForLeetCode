class Solution {
public:
    string shortestSuperstring(vector<string>& words) {
        
        int n = words.size();
        vector<vector<int>> g(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                g[i][j] = overlap(words[i], words[j]);
            }
        }
        vector<vector<string>> dp(1 << n, vector<string>(n));
        for (int mask = 1; mask < (1 << n); ++mask) {
            for (int bit = 0; bit < n; ++bit) {
                if (!(mask & (1 << bit))) continue;
                int pmask = mask ^ (1 << bit);
                if (pmask == 0) {
                    dp[mask][bit] = words[bit];
                } else {
                    for (int i = 0; i < n; ++i) {
                        if (dp[pmask][i].empty()) continue;
                        string t = dp[pmask][i] + words[bit].substr(g[i][bit]);
                        if (dp[mask][bit].empty() || t.length() < dp[mask][bit].length()) {
                            dp[mask][bit] = t;
                        }
                    }
                }
            }
        }
        string res;
        for (int i = 0; i < n; ++i) {
            if (res.empty() || dp[(1 << n) - 1][i].length() < res.length()) {
                res = dp[(1 << n) - 1][i];
            }
        }
        return res;
    }
};