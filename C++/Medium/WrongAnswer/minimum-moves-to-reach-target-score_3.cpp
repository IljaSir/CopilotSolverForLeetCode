class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        
        vector<int> dp(target+1, INT_MAX);
        dp[1] = 1;
        for (int i = 1; i < target; ++i) {
            for (int j = 1, k = 1; j <= maxDoubles && k <= target; ++j, k *= 2) {
                if (i + k > target) break;
                dp[i+k] = min(dp[i+k], dp[i] + j);
            }
        }
        return dp[target];
    }
};