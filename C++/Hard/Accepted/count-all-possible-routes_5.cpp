class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        
        int n = locations.size();
        vector<vector<int>> dp(n, vector<int>(fuel + 1));
        dp[start][0] = 1;
        for (int k = 1; k <= fuel; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == j) continue;
                    int dist = abs(locations[i] - locations[j]);
                    if (k >= dist) {
                        dp[i][k] += dp[j][k - dist];
                        dp[i][k] %= 1000000007;
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k <= fuel; ++k) {
            ans += dp[finish][k];
            ans %= 1000000007;
        }
        return ans;
    }
};