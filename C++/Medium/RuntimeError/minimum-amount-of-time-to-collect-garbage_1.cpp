class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        
        int n = garbage.size();
        vector<vector<int>> dp(n, vector<int>(3, INT_MAX));
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    if (garbage[i - 1][j] == 'M') {
                        dp[i][j] = min(dp[i][j], dp[i - 1][k] + travel[i - 1]);
                    } else if (garbage[i - 1][j] == 'P') {
                        dp[i][j] = min(dp[i][j], dp[i - 1][k] + travel[i - 1]);
                    } else if (garbage[i - 1][j] == 'G') {
                        dp[i][j] = min(dp[i][j], dp[i - 1][k] + travel[i - 1]);
                    }
                }
            }
        }
        return min({dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]});
    }
};