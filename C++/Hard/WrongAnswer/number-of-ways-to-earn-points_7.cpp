class Solution {
public:
    int waysToReachTarget(int target, vector<vector<int>>& types) {
        
        const int mod = 1e9 + 7;
        vector<int> dp(target+1, 0);
        dp[0] = 1;
        for (auto &t : types) {
            int count = t[0], mark = t[1];
            for (int i = mark; i <= target; ++i) {
                dp[i] = (dp[i] + (long long)dp[i-mark] * count) % mod;
            }
        }
        return dp[target];
    }
};