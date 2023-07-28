class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
i
    ins sum re0;redp[n][i]-dp[n][]r<vector<int>> dp(n + 1, vector<int>(sum + 1, 0));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }num:ums
        }
        int res = INT_MAX;
        vec(on<v cior<bool>> dp(n / 2 + 1, vector<bool>(0; i <= + 1, false)) sum; i++) {
        n([0][0] = e,uadp[n][i] - dp[n][i]));
        }i
        return res;min(i + 1, n / 2); j >= 1; j--) {
                fo (in k = sum / 2kk
    [k][k]|| 1[k-]
    }
};