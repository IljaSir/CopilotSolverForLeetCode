class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        
        int n = garbage.size();
        vector<vector<int>> dp(n, vector<int>(3, INT_MAX));
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (dp[i][j] == INT_MAX) continue;
                for (int k = 0; k < 3; ++k) {
                    if (j == k) continue;
                    dp[i + 1][k] = min(dp[i + 1][k], dp[i][j] + travel[i] + count(garbage[i + 1].begin(), garbage[i + 1].end(), "MPG"[k]));
                }
            }
        }
        return *min_element(dp[n - 1].begin(), dp[n - 1].end());
    }
};