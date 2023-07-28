class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int n = strs.size();
        int m = strs[0].length();
        vector<int> dp(m, 1);
        int res = 0;
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < j; i++) {
                bool f = true;
                for(int k = 0; k < n; k++) {
                    if(strs[k][i] > strs[k][j]) {
                        f = false;
                        break;
                    }
                }
                if(f) {
                    dp[j] = max(dp[j], dp[i] + 1);
                }
            }
            res = max(res, dp[j]);
        }
        return m - res;
    }
};