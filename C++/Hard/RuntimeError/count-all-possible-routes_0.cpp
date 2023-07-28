class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        
        int MOD = 1e9 + 7;
        int n = locations.size();
        vector<vector<int>> dp(fuel + 1, vector<int>(n, 0));
        dp[0][start] = 1;
        for (int i = 1; i <= fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        dp[i][j] += dp[i - abs(locations[j] - locations[k])][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        int ret = 0;
        for (int i = 0; i <= fuel; i++) {
            ret += dp[i][finish];
            ret %= MOD;
        }
        return ret;
    }
};