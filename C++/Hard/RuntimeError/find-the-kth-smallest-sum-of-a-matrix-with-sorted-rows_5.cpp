class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> dp(n);
        for (int i = 0; i < m; i++) {
            vector<int> tmp(n * m);
            int index = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    tmp[index++] = dp[k] + mat[i][j];
                }
            }
            sort(tmp.begin(), tmp.end());
            for (int j = 0; j < n; j++) {
                dp[j] = tmp[j];
            }
        }
        return dp[k - 1];
    }
};