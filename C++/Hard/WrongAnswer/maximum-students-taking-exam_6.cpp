class Solution {
public:
    int maxStudents(vector<vector<char>>& seats) {
        
        int m = seats.size();
        int n = seats[0].size();
        vector<vector<int>> dp(m, vector<int>(1 << n, -1));
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (seats[i][j] == '#') continue;
                for (int k = 0; k < (1 << n); ++k) {
                    if (dp[i][k] == -1) continue;
                    bool ok = true;
                    for (int t = 0; t < n; ++t) {
                        if ((k & (1 << t)) && (j == t || j == t - 1 || j == t + 1)) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;
                    int mask = k | (1 << j);
                    dp[i + 1][mask] = max(dp[i + 1][mask], dp[i][k] + __builtin_popcount(mask));
                    ans = max(ans, dp[i + 1][mask]);
                }
            }
        }
        return ans;
    }
};