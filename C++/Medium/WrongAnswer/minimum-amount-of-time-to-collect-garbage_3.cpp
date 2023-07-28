class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        
        int n = garbage.size();
        vector<vector<int>> dp(n, vector<int>(3, 0));
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i-1][0] + travel[i-1];
            dp[i][1] = dp[i-1][1] + travel[i-1];
            dp[i][2] = dp[i-1][2] + travel[i-1];
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    if (j == k) continue;
                    int cost = 0;
                    for (char c : garbage[i]) {
                        if (c == 'M' && j == 0) ++cost;
                        if (c == 'P' && j == 1) ++cost;
                        if (c == 'G' && j == 2) ++cost;
                    }
                    dp[i][j] = min(dp[i][j], dp[i-1][k] + cost);
                }
            }
        }
        return min({dp[n-1][0], dp[n-1][1], dp[n-1][2]});
    }
};