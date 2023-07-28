class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        if (strs.size() == 1) return 0;
        int n = strs.size();
        int m = strs[0].size();
        vector<int> dp(m, 1);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int flag = 0;
                for (int k = 0; k < n; k++) {
                    if (strs[k][i] < strs[k][j]) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            ans = max(ans, dp[i]);
        }
        return m - ans;
    }
};