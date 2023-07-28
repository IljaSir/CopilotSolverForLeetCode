class Solution {
public:
    string shortestSuperstring(vector<string>& words) {
        
        int n = words.size();
        vector<vector<int>> overlap(n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    int m = min(words[i].size(), words[j].size());
                    for (int k = m; k >= 0; --k) {
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
                        if (dp[pmask][i].empty()) continue;
                        string t = dp[pmask][i] + words[bit].substr(overlap[i][bit]);
                        if (dp[mask][bit].empty() || t.size() < dp[mask][bit].size()) {
                            dp[mask][bit] = t;
                        }
                    }
                }
            }
        }
        string res;
        for (string& s : dp.back()) {
            if (res.empty() || s.size() < res.size()) {
                res = s;
            }
        }
        return res;
    }
};