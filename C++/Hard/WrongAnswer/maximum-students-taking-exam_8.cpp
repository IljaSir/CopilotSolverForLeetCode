class Solution {
public:
    int maxStudents(vector<vector<char>>& seats) {
        
        int m = seats.size();
        int n = seats[0].size();
        int max_mask = (1 << n);
        int dp[m][max_mask];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < max_mask; j++) {
                if (check(j, seats, i, n)) {
                    if (i == 0) {
                        dp[i][j] = __builtin_popcount(j);
                    } else {
                        for (int k = 0; k < max_mask; k++) {
                            if (check(k, seats, i - 1, n) && (j & k) == 0) {
                                dp[i][j] = max(dp[i][j], dp[i - 1][k] + __builtin_popcount(j));
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < max_mask; i++) {
            ans = max(ans, dp[m - 1][i]);
        }
        return ans;
    }
    bool check(int mask, vector<vector<char>>& seats, int row, int n) {
        for (int i = 0; i < n; i++) {
            if (seats[row][i] == '#') {
                if (mask & (1 << i)) {
                    return false;
                }
            }
        }
        return true;
    }
};