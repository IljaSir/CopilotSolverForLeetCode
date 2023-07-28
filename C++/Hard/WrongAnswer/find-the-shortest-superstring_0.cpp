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
        vector<vector<int>> dp(1 << n, vector<int>(n, INT_MAX / 2));
        vector<vector<int>> parent(1 << n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            dp[1 << i][i] = words[i].size();
        }
        for (int mask = 1; mask < (1 << n); ++mask) {
            for (int bit = 0; bit < n; ++bit) {
                if (!(mask & (1 << bit))) {
                    continue;
                }
                int pmask = mask ^ (1 << bit);
                for (int i = 0; i < n; ++i) {
                    if (dp[pmask][i] + overlap[i][bit] < dp[mask][bit]) {
                        dp[mask][bit] = dp[pmask][i] + overlap[i][bit];
                        parent[mask][bit] = i;
                    }
                }
            }
        }
        vector<int> perm(n);
        int t = (1 << n) - 1;
        iota(perm.begin(), perm.end(), 0);
        int last = min_element(dp.back().begin(), dp.back().end()) - dp.back().begin();
        string res = words[last];
        for (int mask = t; mask; mask = t) {
            int i = parent[mask][last];
            int bit = last;
            t = mask ^ (1 << bit);
            res = words[i].substr(0, words[i].size() - overlap[i][bit]) + res;
            last = i;
        }
        return res;
    }
};