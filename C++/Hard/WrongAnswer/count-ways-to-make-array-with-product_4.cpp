class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        int mod = 1e9+7;
        vector<int> res;
        for (auto& q: queries) {
            int n = q[0], k = q[1];
            vector<int> dp(k+1);
            for (int i = 1; i <= k; ++i) {
                dp[i] = i;
                for (int j = 2; j <= n; ++j) {
                    dp[i] = (dp[i] + dp[i/j]) % mod;
                }
            }
            res.push_back(dp[k]);
        }
        return res;
    }
};