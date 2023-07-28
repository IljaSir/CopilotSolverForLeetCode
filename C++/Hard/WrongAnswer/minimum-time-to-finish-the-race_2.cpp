class Solution {
public:
    int minimumFinishTime(vector<vector<int>>& tires, int changeTime, int numLaps) {
        
        int n = tires.size();
        vector<vector<int>> dp(n, vector<int>(numLaps+1, INT_MAX));
        for (int i = 0; i < n; ++i) {
            dp[i][1] = tires[i][0];
        }
        for (int j = 2; j <= numLaps; ++j) {
            for (int i = 0; i < n; ++i) {
                for (int k = 0; k < n; ++k) {
                    dp[i][j] = min(dp[i][j], dp[k][j-1] + tires[i][0] + changeTime);
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            ans = min(ans, dp[i][numLaps]);
        }
        return ans;
    }
};