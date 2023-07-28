class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> dp(n, INT_MAX);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if (stones[j] - stones[i] > dp[i] + 1) break;
                dp[j] = min(dp[j], max(dp[i], stones[j] - stones[i]));
            }
        }
        return dp[n - 1];
    }
};