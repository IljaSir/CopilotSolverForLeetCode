class Solution {
public:
    int maxHeight(vector<vector<int>>& cuboids) {
        
        int n = cuboids.size();
        for (auto& c: cuboids) {
            sort(c.begin(), c.end());
        }
        sort(cuboids.begin(), cuboids.end());
        vector<int> dp(n);
        for (int i = 0; i < n; ++i) {
            dp[i] = cuboids[i][2];
        }
        int res = dp[0];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};