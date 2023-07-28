class Solution {
public:
    int maxStudents(vector<vector<char>>& seats) {
        
        int m = seats.size(), n = seats[0].size();
        vector<vector<int>> dp(m, vector<int>(1 << n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < (1 << n); ++j) {
                if (check(j, seats, i, n)) {
                    if (i == 0) {
                        dp[i][j] = __builtin_popcount(j);
                    } else {
                        for (int k = 0; k < (1 << n); ++k) {
                            if (check(k, seats, i - 1, n) && (j & k) == 0) {
                                dp[i][j] = max(dp[i][j], dp[i - 1][k] + __builtin_popcount(j));
                            }
                        }
                    }
                }
            }
        }
        return *max_element(dp[m - 1].begin(), dp[m - 1].end());
    }
};