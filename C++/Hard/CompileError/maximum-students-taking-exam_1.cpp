class Solution {
public:
    int maxStudents(vector<vector<char>>& seats) {
        
        int m = seats.size(), n = seats[0].size();
        vector<vector<int>> dp(m + 1, vector<int>(1 << n, -1));
        dp[0][0] = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < 1 << n; ++j) {
                if (dp[i][j] == -1) continue;
                for (int k = 0; k < 1 << n; ++k) {
                    if (isValid(j, k, n, seats[i])) {
                        dp[i + 1][k] = max(dp[i + 1][k], dp[i][j] + __builtin_popcount(k));
                    }
                }
            }
        }
        return *max_element(dp[m].begin(), dp[m].end());
    }
};