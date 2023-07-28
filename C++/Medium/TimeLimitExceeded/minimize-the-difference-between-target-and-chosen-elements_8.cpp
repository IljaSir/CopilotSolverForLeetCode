class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int m = mat.size();
        int n = mat[0].size();
        int dp[71][8001] = {0};
        for (int i = 0; i < 71; i++) {
            for (int j = 0; j < 8001; j++) {
                dp[i][j] = 8001;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 8001; j++) {
                for (int k = 0; k < n; k++) {
                    if (j - mat[i][k] >= 0) {
                        dp[i+1][j] = min(dp[i+1][j], dp[i][j - mat[i][k]] + mat[i][k]);
                    }
                }
            }
        }
        int ans = 8001;
        for (int i = 0; i < 8001; i++) {
            ans = min(ans, abs(target - dp[m][i]));
        }
        return ans;
    }
};