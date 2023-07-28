class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        
        int n = garbage.size();
        int m = garbage[0].size();
        vector<vector<int>> dp(n, vector<int>(3, INT_MAX));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (garbage[i][j] == 'M') {
                    if (i == 0) {
                        dp[i][0] = 0;
                    } else {
                        dp[i][0] = min(dp[i][0], dp[i - 1][0]);
                        dp[i][0] = min(dp[i][0], dp[i - 1][1] + travel[i - 1]);
                        dp[i][0] = min(dp[i][0], dp[i - 1][2] + travel[i - 1]);
                    }
                } else if (garbage[i][j] == 'P') {
                    if (i == 0) {
                        dp[i][1] = 0;
                    } else {
                        dp[i][1] = min(dp[i][1], dp[i - 1][0] + travel[i - 1]);
                        dp[i][1] = min(dp[i][1], dp[i - 1][1]);
                        dp[i][1] = min(dp[i][1], dp[i - 1][2] + travel[i - 1]);
                    }
                } else {
                    if (i == 0) {
                        dp[i][2] = 0;
                    } else {
                        dp[i][2] = min(dp[i][2], dp[i - 1][0] + travel[i - 1]);
                        dp[i][2] = min(dp[i][2], dp[i - 1][1] + travel[i - 1]);
                        dp[i][2] = min(dp[i][2], dp[i - 1][2]);
                    }
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < 3; i++) {
            ans = min(ans, dp[n - 1][i]);
        }
        return ans;
    }
};