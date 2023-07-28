class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        
        int m = mat.size(), n = mat[0].size();
        vector<int> dp(n, 0);
        for(int i = 0; i < m; i++){
            vector<int> tmp(n * m + 1, INT_MAX);
            for(int j = 0; j < n; j++){
                for(int t = 0; t < n * m + 1; t++){
                    if(dp[j] != INT_MAX && t - dp[j] < n * m + 1) tmp[t] = min(tmp[t], mat[i][j] + t - dp[j]);
                }
            }
            dp = tmp;
        }
        return dp[k];
    }
};