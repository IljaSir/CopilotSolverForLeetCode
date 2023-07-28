class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int m = strs.size();
        int n = strs[0].size();
        int ans = 0;
        vector<int> dp(m, 1);
        for (int j = 0; j < n; ++j) {
            vector<int> ndp(m, 1);
            for (int i = 0; i < m; ++i) {
                for (int k = 0; k < i; ++k) {
                    if (strs[k][j] <= strs[i][j]) {
                        ndp[i] = max(ndp[i], dp[k] + 1);
                    }
                }
            }
            dp = ndp;
            ans = max(ans, *max_element(dp.begin(), dp.end()));
        }
        return n - ans;
    }
};