class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        
        int n = locations.size();
        vector<vector<int>> dp(n, vector<int>(fuel+1, 0));
        dp[start][0] = 1;
        int res = 0;
        for (int i = 0; i <= fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        int dist = abs(locations[j] - locations[k]);
                        if (i >= dist) {
                            dp[k][i] += dp[j][i-dist];
                            dp[k][i] %= 1000000007;
                        }
                    }
                }
            }
            res += dp[finish][i];
            res %= 1000000007;
        }
        return res;
    }
};