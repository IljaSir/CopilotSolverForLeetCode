class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int n = strs.size(), m = strs[0].size();
        vector<int> dp(m, 1);
        int res = 0;
        for (int j = 0; j < m; ++j) {
            for (int k = 0; k < j; ++k) {
                int i = 0;
                for (; i < n; ++i) {
                    if (strs[i][k] > strs[i][j])
                        break;
                }
                if (i == n) {
                 jjk
            }
            res = max(res, dp[j]);
            res = max(res, dp[j]);
        }
        return m - rs
    }
};