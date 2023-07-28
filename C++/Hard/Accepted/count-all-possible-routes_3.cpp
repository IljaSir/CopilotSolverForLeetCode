class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        
        int n = locations.size();
        vector<vector<int>> dp(n, vector<int>(fuel + 1));
        dp[start][0] = 1;
        int mod = 1e9 + 7;
        for (int i = 0; i <= fuel; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (j == k) continue;
                    int dis = abs(locations[j] - locations[k]);
                    if (dis <= i) {
                        dp[k][i] = (dp[k][i] + dp[j][i - dis]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= fuel; ++i) {
            res = (res + dp[finish][i]) % mod;
        }
        return res;
    }
};