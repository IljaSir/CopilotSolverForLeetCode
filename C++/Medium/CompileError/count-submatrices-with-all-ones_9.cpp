class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        
        int n = mat.size(), m = mat[0].size();
        int res = 0;
        vector<int> dp(m, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1) {
                    dp[j] += 1;
                } else {
                    dp[j] = 0;
                }
            }
            res += count(dp);
        }
        return res;
    }
};