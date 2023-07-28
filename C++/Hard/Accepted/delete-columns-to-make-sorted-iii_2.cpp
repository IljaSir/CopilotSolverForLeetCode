class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int n = strs.size();
        int m = strs[0].size();
        vector<int> dp(m, 1);
        for (int j = 1; j < m; ++j) {
            for (int i = 0; i < j; ++i) {
                bool sorted = true;
                for (int k = 0; k < n; ++k) {
                    if (strs[k][i] > strs[k][j]) {
                        sorted = false;
                        break;
                    }
                }
                if (sorted) {
                    dp[j] = max(dp[j], dp[i] + 1);
                }
            }
        }
        return m - *max_element(dp.begin(), dp.end());
    }
};