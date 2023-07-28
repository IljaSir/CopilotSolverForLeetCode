class Solution {
public:
    int minSideJumps(vector<int>& obstacles) {
        
        int n = obstacles.size();
        vector<int> dp(4, 0);
        for (int i = 1; i < n; ++i) {
            int obs = obstacles[i];
            if (obs) dp[obs] = INT_MAX;
            for (int j = 1; j <= 3; ++j) {
                if (j != obs) {
                    dp[j] = min(dp[j], dp[j-1]+1);
                    dp[j] = min(dp[j], dp[j+1]+1);
                }
            }
        }
        return min(dp[1], min(dp[2], dp[3]));
    }
};