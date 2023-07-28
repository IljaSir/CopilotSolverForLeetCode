class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> dp(3, 1);
        for (int i = 1; i < n; ++i) {
            if (obstacles[i] == 0) {
                for (int j = 0; j < 3; ++j) dp[j] = min({dp[0], dp[1], dp[2]}) + (j == 1 ? 0 : 1);
            } else {
                int j = obstacles[i] - 1;
                dp[j] = INT_MAX;
                for (int k = 0; k < 3; ++k) if (k != j) dp[j] = min(dp[j], dp[k] + (j == 1 ? 0 : 1));
            }
        }
        return min({dp[0], dp[1], dp[2]});
    }
};