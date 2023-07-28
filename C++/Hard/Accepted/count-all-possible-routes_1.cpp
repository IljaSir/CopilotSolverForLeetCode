class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        
        const int MOD = 1e9 + 7;
        int n = locations.size();
        vector<vector<int>> dp(n, vector<int>(fuel + 1, 0));
        dp[start][0] = 1;
        for (int i = 0; i <= fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    int cost = abs(locations[j] - locations[k]);
                    if (i >= cost) {
                        dp[j][i] = (dp[j][i] + dp[k][i - cost]) % MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= fuel; i++) {
            ans = (ans + dp[finish][i]) % MOD;
        }
        return ans;
    }
};