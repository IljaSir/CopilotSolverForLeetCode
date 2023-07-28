class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int n = strs.size();
        int m = strs[0].size();
        vector<int> dp(m, 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int k = 0;
                for (; k < n; k++) {
                    if (strs[k][j] > strs[k][i]) {
                        break;
                    }
                }
                if (k == n) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        return m - *max_element(dp.begin(), dp.end());
    }
};