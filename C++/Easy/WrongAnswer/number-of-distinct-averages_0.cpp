class Solution {
public:
    int distinctAverages(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = dp[i][j - 1] + nums[j];
            }
        }
        unordered_set<double> s;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                s.insert(dp[i][j] * 1.0 / (j - i + 1));
            }
        }
        return s.size();
    }
};