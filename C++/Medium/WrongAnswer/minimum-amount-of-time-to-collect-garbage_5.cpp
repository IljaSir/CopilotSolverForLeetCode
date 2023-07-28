class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        
        int n = garbage.size();
        vector<vector<int>> dp(n, vector<int>(3, 1e9));
        dp[0][0] = (garbage[0].find('M') != string::npos) * 1;
        dp[0][1] = (garbage[0].find('P') != string::npos) * 1;
        dp[0][2] = (garbage[0].find('G') != string::npos) * 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    if (k != j) {
                        dp[i][j] = min(dp[i][j], dp[i - 1][k] + (garbage[i].find('M' + j) != string::npos) * 1 + travel[i - 1]);
                    }
                }
            }
        }
        return min({dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]});
    }
};