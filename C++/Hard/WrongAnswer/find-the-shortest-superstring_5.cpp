class Solution {
public:
    string shortestSuperstring(vector<string>& words) {
        
        int n = words.size();
        vector<vector<int>> overlap(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                for (int k = min(words[i].size(), words[j].size()); k >= 0; --k) {
                    if (words[i].substr(words[i].size() - k) == words[j].substr(0, k)) {
                        overlap[i][j] = k;
                        break;
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
                        if (dp[pmask][i].empty() || overlap[i][bit] == 0) continue;
                        string cand = dp[pmask][i] + words[bit].substr(overlap[i][bit]);
                        if (dp[mask][bit].empty() || cand.size() < dp[mask][bit].size()) {
                            dp[mask][bit] = cand;
                        }
                    }
                }
            }
        }
        string ans;
        for (int i = 0; i < n; ++i) {
            if (ans.empty() || dp[(1 << n) - 1][i].size() < ans.size()) {
                ans = dp[(1 << n) - 1][i];
            }
        }
        return ans;
    }
};