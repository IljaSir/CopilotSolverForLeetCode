class Solution {
public:
    int waysToReachTarget(int target, vector<vector<int>>& types) {
        
        const int M = 1000000007;
        vector<int> dp(target+1, 0);
        dp[0] = 1;
        for (auto &t : types) {
            for (int i = t[1]; i <= target; ++i) {
                dp[i] = (dp[i] + (long long)dp[i-t[1]] * t[0]) % M;
            }
        }
        return dp[target];
    }
};