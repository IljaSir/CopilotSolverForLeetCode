class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> dp(4, 0);
        for (int i = 1; i < n; ++i) {
            if (obstacles[i] == 0) {
                dp[1] = min(dp[1], min(dp[2], dp[3]) + 1);
                dp[2] = min(dp[1], min(dp[2], dp[3]) + 1);
                dp[3] = min(dp[1], min(dp[2], dp[3]) + 1);
            } else {
                dp[obstacles[i]] = INT_MAX;
                dp[1] = min(dp[1], min(dp[2], dp[3]) + 1);
                dp[2] = min(dp[1], min(dp[2], dp[3]) + 1);
                dp[3] = min(dp[1], min(dp[2], dp[3]) + 1);
            }
        }
        return min(dp[1], min(dp[2], dp[3]));
    }
};