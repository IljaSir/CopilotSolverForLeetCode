class Solution {
public:
    int maxStudents(vector<vector<char>>& seats) {
        
        int m = seats.size();
        int n = seats[0].size();
        vector<vector<int>> dp(m, vector<int>(1 << n, -1));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '#') {
                    for (int k = 0; k < (1 << n); k++) {
                        if (k & (1 << j)) {
                            dp[i][k] = -1;
                        }
                    }
                }
            }
        }
        return dfs(seats, dp, 0, 0, 0);
    }
    
    int dfs(vector<vector<char>>& seats, vector<vector<int>>& dp, int i, int j, int mask) {
        if (i >= seats.size()) {
            return 0;
        }
        if (dp[i][mask] != -1) {
            return dp[i][mask];
        }
        int ans = 0;
        int n = seats[0].size();
        int cur = 0;
        int next = 0;
        for (int k = 0; k < n; k++) {
            if (mask & (1 << k)) {
                cur++;
            }
            if (j & (1 << k)) {
                next++;
            }
        }
        ans = max(ans, cur + dfs(seats, dp, i + 1, 0, j));
        if (i < seats.size() - 1) {
            ans = max(ans, cur + dfs(seats, dp, i + 2, 0, j));
        }
        if (next != cur) {
            ans = max(ans, cur + dfs(seats, dp, i + 1, j, mask));
            if (i < seats.size() - 1) {
                ans = max(ans, cur + dfs(seats, dp, i + 2, j, mask));
            }
        }
        dp[i][mask] = ans;
        return ans;
    }
};