class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        int n = queries.size();
        vector<int> ans(n, 0);
        for (int i = 0; i < n; ++i) {
            int ni = queries[i][0], ki = queries[i][1];
            vector<int> dp(ki + 1, 0);
            for (int j = 1; j <= ki; ++j) {
                dp[j] = 1;
            }
            for (int j = 2; j <= ni; ++j) {
                for (int k = 1; k <= ki; ++k) {
                    for (int l = 1; l * k <= ki; ++l) {
                        dp[l * k] += dp[k];
                        dp[l * k] %= 1000000007;
                    }
                }
            }
            ans[i] = dp[ki];
        }
        return ans;
    }
};