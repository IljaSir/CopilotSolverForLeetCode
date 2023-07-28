class Solution {
public:
    int minimizeTheDifference(vector<vector<int>>& mat, int target) {
        
        int m = mat.size();
        int n = mat[0].size();
        int sum = 0;
        for(int i = 0; i < m; i++) {
            sum += *min_element(mat[i].begin(), mat[i].end());
        }
        if(sum >= target) return sum - target;
        int maxSum = 0;
        for(int i = 0; i < m; i++) {
            maxSum += *max_element(mat[i].begin(), mat[i].end());
        }
        if(maxSum <= target) return target - maxSum;
        vector<int> dp(maxSum - sum + 1, INT_MAX);
        dp[0] = 0;
        for(int i = 0; i < m; i++) {
            for(int j = maxSum - sum; j >= 0; j--) {
                if(dp[j] != INT_MAX) {
                    for(int k = 0; k < n; k++) {
                        if(j + mat[i][k] - sum <= maxSum - sum) {
                            dp[j + mat[i][k] - sum] = min(dp[j + mat[i][k] - sum], dp[j] + mat[i][k]);
                        }
                    }
                }
            }
        }
        int res = INT_MAX;
        for(int i = 0; i <= maxSum - sum; i++) {
            if(dp[i] != INT_MAX) {
                res = min(res, abs(dp[i] + i + sum - target));
            }
        }
        return res;
    }
};