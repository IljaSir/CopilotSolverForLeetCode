class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> dp(4, 1);
        dp[obstacles[0]] = INT_MAX;
        for (int i = 1; i < n; ++i) {
            vector<int> ndp(4, INT_MAX);
            for (int j = 1; j <= 3; ++j) {
                if (obstacles[i] != j) {
                    ndp[j] = min(ndp[j], dp[j]);
                }
            }
            for (int j = 1; j <= 3; ++j) {
                if (obstacles[i] != j) {
                    for (int k = 1; k <= 3; ++k) {
                        if (j != k) {
                            ndp[k] = min(ndp[k], dp[j] + 1);
                        }
                    }
                }
            }
            dp = ndp;
        }
        return *min_element(dp.begin() + 1, dp.end());
    }
};