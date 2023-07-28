class Solution {
public:
    int maxStudents(vector<vector<char>>& seats) {
        
        int m = seats.size(), n = seats[0].size();
        vector<int> dp(1 << n, -1);
        dp[0] = 0;
        for (int i = 0; i < m; ++i) {
            vector<int> ndp(1 << n, -1);
            for (int j = 0; j < (1 << n); ++j) {
                if (dp[j] == -1) continue;
                bool valid = true;
                for (int k = 0; k < n; ++k) {
                    if (((j >> k) & 1) && seats[i][k] == '#') {
                        valid = false;
                        break;
                    }
                    if (k > 0 && ((j >> k) & 1) && ((j >> (k - 1)) & 1)) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) continue;
                for (int k = 0; k < (1 << n); ++k) {
                    bool valid = true;
                    for (int p = 0; p < n; ++p) {
                        if (((k >> p) & 1) && seats[i][p] == '#') {
                            valid = false;
                            break;
                        }
                        if (p > 0 && ((k >> p) & 1) && ((k >> (p - 1)) & 1)) {
                            valid = false;
                            break;
                        }
                        if (p < n - 1 && ((k >> p) & 1) && ((k >> (p + 1)) & 1)) {
                            valid = false;
                            break;
                        }
                        if (((j >> p) & 1) && ((k >> p) & 1)) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) continue;
                    ndp[k] = max(ndp[k], dp[j] + __builtin_popcount(k));
                }
            }
            dp = ndp;
        }
        return *max_element(dp.begin(), dp.end());
    }
};