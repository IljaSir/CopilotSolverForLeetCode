class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> dp(target+1, 10000);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            vector<int> temp(target+1, 10000);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= target; k++) {
                    if (k >= mat[i][j]) {
                        temp[k] = min(temp[k], dp[k-mat[i][j]]);
                    }
                }
            }
            for (int j = 0; j <= target; j++) {
                dp[j] = min(dp[j], temp[j] + 1);
            }
        }
        int ans = 10000;
        for (int i = 0; i <= target; i++) {
            ans = min(ans, abs(i-target) + dp[i]);
        }
        return ans;
    }
};