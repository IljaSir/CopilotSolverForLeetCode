class Solution {
public:
    string shortestSuperstring(vector<string>& words) {
        
        int n = words.size();
        vector<vector<int>> overlap(n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    for (int k = min(words[i].size(), words[j].size()); k >= 0; --k) {
                        if (words[i].substr(words[i].size() - k) == words[j].substr(0, k)) {
                            overlap[i][j] = k;
                            break;
                        }
                    }
                }
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
                        if (dp[pmask][i].size() > 0 && dp[mask][bit].size() < dp[pmask][i].size() + words[bit].size() - overlap[i][bit]) {
                            dp[mask][bit] = dp[pmask][i] + words[bit].substr(overlap[i][bit]);
                        }
                    }
                }
            }
        }
        string res = dp[(1 << n) - 1][0];
        for (int i = 1; i < n; ++i) {
            if (res.size() > dp[(1 << n) - 1][i].size()) {
                res = dp[(1 << n) - 1][i];
            }
        }
        return res;
    }
};