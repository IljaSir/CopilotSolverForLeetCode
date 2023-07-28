class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        
        int n = locations.size();
        vector<vector<int>> dp(n, vector<int>(fuel + 1));
        dp[finish][0] = 1;
        for (int i = 1; i <= fuel; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (j == k) continue;
                    dp[j][i] = (dp[j][i] + dp[k][i - 1]) % 1000000007;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= fuel; ++i) {
            res = (res + dp[start][i] * (abs(locations[start] - locations[finish]) <= i ? 1 : 0)) % 1000000007;
        }
        return res;
    }
};