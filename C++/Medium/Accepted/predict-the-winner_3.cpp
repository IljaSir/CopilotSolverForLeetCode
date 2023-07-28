class Solution {
public:
    bool PredictTheWinner(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int a = nums[j] - dp[j + 1][j + i];
                int b = nums[j + i] - dp[j][j + i - 1];
                dp[j][j + i] = max(a, b);
            }
        }
        return dp[0][n - 1] >= 0;
    }
};