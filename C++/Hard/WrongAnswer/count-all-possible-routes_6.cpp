class Solution {
public:
    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        
        int n = locations.size();
        vector<vector<int>> dp(n, vector<int>(fuel + 1, 0));
        dp[start][fuel] = 1;
        int ans = 0;
        for (int i = fuel; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (dp[j][i] > 0) {
                    for (int k = 0; k < n; k++) {
                        if (k != j) {
                            int f = i - abs(locations[j] - locations[k]);
                            if (f >= 0) {
                                dp[k][f] += dp[j][i];
                                dp[k][f] %= 1000000007;
                                if (k == finish) {
                                    ans += dp[j][i];
                                    ans %= 1000000007;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
};