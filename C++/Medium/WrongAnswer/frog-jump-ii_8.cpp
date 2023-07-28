class Solution {
public:
    int maxJump(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> dp(n, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            while (j < n && stones[j] - stones[i] <= dp[i]) {
                dp[j] = min(dp[j], stones[j] - stones[i]);
                ++j;
            }
            --j;
            if (j + 1 < n) {
                dp[j + 1] = min(dp[j + 1], stones[j + 1] - stones[i]);
            }
        }
        return dp[n - 1];
    }
};