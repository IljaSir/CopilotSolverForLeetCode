class Solution {
public:
    int minimumFinishTime(vector<vector<int>>& tires, int changeTime, int numLaps) {
        
        int n = tires.size();
        vector<vector<long long>> dp(n, vector<long long>(2, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][0] = tires[i][0] * tires[i][1];
            dp[i][1] = tires[i][0] * tires[i][1] * tires[i][1];
        }
        for (int i = 1; i < numLaps; ++i) {
            vector<vector<long long>> tmp(n, vector<long long>(2, 0));
            for (int j = 0; j < n; ++j) {
                tmp[j][0] = dp[j][0] + tires[j][0] * tires[j][1];
                tmp[j][1] = dp[j][1] + tires[j][0] * tires[j][1] * tires[j][1];
            }
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (j == k) continue;
                    tmp[j][0] = min(tmp[j][0], dp[k][0] + changeTime + tires[j][0] * tires[j][1]);
                    tmp[j][1] = min(tmp[j][1], dp[k][1] + changeTime + tires[j][0] * tires[j][1] * tires[j][1]);
                }
            }
            dp = tmp;
        }
        long long ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            ans = min(ans, dp[i][0]);
            ans = min(ans, dp[i][1]);
        }
        return ans;
    }
};