class Solution {
public:
    int waysToReachTarget(int target, vector<vector<int>>& types) {
        
        int mod = 1e9 + 7;
        vector<int> dp(target + 1, 0);
        dp[0] = 1;
        
        for (auto& type: types) {
            for (int i = type[1]; i <= target; i++) {
                dp[i] = (dp[i] + dp[i - type[1]]) % mod;
            }
        }
        return dp[target];
    }
};