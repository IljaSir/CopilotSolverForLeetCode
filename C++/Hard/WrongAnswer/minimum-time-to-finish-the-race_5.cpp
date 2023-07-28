class Solution {
public:
    int minimumFinishTime(vector<vector<int>>& tires, int changeTime, int numLaps) {
        
        int n = tires.size();
        vector<long long> dp(n, 0);
        for (int i = 0; i < n; i++) {
            dp[i] = tires[i][0] * 1LL * pow(tires[i][1], numLaps - 1);
        }
        sort(dp.begin(), dp.end());
        for (int i = 1; i < n; i++) {
            dp[i] = min(dp[i], dp[i - 1] + changeTime);
        }
        return dp[n - 1];
    }
};