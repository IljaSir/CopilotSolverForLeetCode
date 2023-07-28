class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int m = strs.size(), n = strs[0].size();
        vector<int> dp(n, 1);
        int ans = n - 1;
        for (int j = n - 1; j >= 0; --j) {
            for (int k = j + 1; k < n; ++k) {
                bool sorted = true;
                for (int i = 0; i < m; ++i) {
                    if (strs[i][j] > strs[i][k]) {
                        sorted = false;
                        break;
                    }
                }
                if (sorted) {
                    dp[j] = max(dp[j], dp[k] + 1);
                }
            }
            ans = min(ans, n - dp[j]);
        }
        return ans;
    }
};