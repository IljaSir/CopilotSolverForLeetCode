class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int n = mat.size();
        int m = mat[0].size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += *min_element(mat[i].begin(), mat[i].end());
        }
        if (sum >= target) return sum - target;
        vector<int> dp(sum + 1, 0);
        for (int i = 0; i < n; i++) {
            vector<int> tmp(sum + 1, 0);
            for (int j = 0; j < m; j++) {
                for (int k = mat[i][j]; k <= sum; k++) {
                    tmp[k] = max(tmp[k], dp[k - mat[i][j]] + mat[i][j]);
                }
            }
            dp = tmp;
        }
        int res = INT_MAX;
        for (int i = target; i <= sum; i++) {
            res = min(res, i - dp[i]);
        }
        return res;
    }
};