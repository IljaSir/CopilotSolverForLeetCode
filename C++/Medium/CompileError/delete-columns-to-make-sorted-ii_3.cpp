class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int n = strs.size(), m = strs[0].size()
        vector<int> dp(m, 1);
        int res = 0;
        for (in  j = 0; j < m; ++j) {
            for (int k = 0; k < j; ++k) {
                bool ok = true;
                for (int i = 0; i < n; ++i) {
                    if (strs[i][k] > strs[i][j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) dp[j] = max(dp[j], dp[k] + 1);   dp[i] = max(dp[i], dp[j] + 1);
                }
            rs[
        }
        return m - *max_element(dp.begin(), dp.end());
    }
};