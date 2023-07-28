class Solution {
public:
    int waysToReachTarget(int target, vector<vector<int>>& types) {
        
        int n = types.size();
        vector<int> dp(target + 1, 0);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int k = 1; j - k * types[i][1] >= 0 && k <= types[i][0]; ++k) {
                    dp[j] = (dp[j] + dp[j - k * types[i][1]]) % 1000000007;
                }
            }
        }
        return dp[target];
    }
};