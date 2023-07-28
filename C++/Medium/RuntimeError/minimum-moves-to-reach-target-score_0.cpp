class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        
        vector<int> dp(target + 1, INT_MAX);
        dp[1] = 0;
        for (int i = 2; i <= target; ++i) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < maxDoubles; ++j) {
                if (i < (1 << j)) {
                    break;
                }
                dp[i] = min(dp[i], dp[i - (1 << j)] + 1);
            }
        }
        return dp[target];
    }
};