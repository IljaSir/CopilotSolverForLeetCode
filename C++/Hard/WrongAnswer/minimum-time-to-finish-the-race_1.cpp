class Solution {
public:
    int minimumFinishTime(vector<vector<int>>& tires, int changeTime, int numLaps) {
        
        int n = tires.size();
        vector<vector<int>> dp(n, vector<int>(2, 0));
        for (int i = 0; i < n; i++) {
            dp[i][0] = tires[i][0];
            dp[i][1] = tires[i][0] * tires[i][1];
        }
        sort(dp.begin(), dp.end(), [](vector<int> &a, vector<int> &b) {
            return a[1] < b[1];
        });
        vector<int> dp2(n, 0);
        for (int i = 0; i < n; i++) {
            dp2[i] = dp[i][0] * tires[i][1];
        }
        int ans = dp2[0] * numLaps;
        for (int i = 0; i < n; i++) {
            int t = dp[i][0];
            int c = dp[i][1];
            int temp = c * numLaps;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int t2 = dp[j][0];
                int c2 = dp[j][1];
                int t3 = max(0, t2 - t);
                int t4 = (t3 + t - 1) / t;
                temp += t4 * changeTime + (t4 + 1) * t2 * tires[i][1];
            }
            ans = min(ans, temp);
        }
        return ans;
    }
};