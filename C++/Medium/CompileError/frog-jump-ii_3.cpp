class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        int maxJump = 0;
        for (int i = 1; i < n; i++) {
            maxJump = max(maxJump, stones[i] - stones[i-1]);
        }
        return maxJump;
    }
    int minCost(vector<int>& stones) {
        int n = stones.size();
        int maxJump = maxJump(stones);
        vector<int> dp(n, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && stones[j] - stones[i] <= maxJump; j++) {
                dp[j] = min(dp[j], dp[i] + stones[j] - stones[i]);
            }
        }
        return dp[n-1];
    }
};