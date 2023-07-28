class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int n = strs.size(), m = strs[0].size();
        vector<int> dp(m, 1);
        int res = m - 1;
        for (int j = m - 1; j >= 0; --j) {
            for (int k = j + 1; k < m; ++k) {
                bool isSorted = true;
                for (int i = 0; i < n; ++i) {
                    if (strs[i][j] > strs[i][k]) {
                        isSorted = false;
                        break;
                    }
                }
                if (isSorted) {
                    dp[j] = max(dp[j], dp[k] + 1);
                }
            }
            res = min(res, m - dp[j]);
        }
        return res;
    }
};