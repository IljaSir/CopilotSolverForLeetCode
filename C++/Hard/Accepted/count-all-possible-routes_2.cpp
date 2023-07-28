class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        
        int n = locations.size();
        int mod = 1e9 + 7;
        vector<vector<int>> dp(n, vector<int>(fuel + 1));
        dp[start][0] = 1;
        for (int i = 0; i < fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    int dist = abs(locations[j] - locations[k]);
                    if (i + dist <= fuel) {
                        dp[k][i + dist] = (dp[k][i + dist] + dp[j][i]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= fuel; i++) {
            res = (res + dp[finish][i]) % mod;
        }
        return res;
    }
};