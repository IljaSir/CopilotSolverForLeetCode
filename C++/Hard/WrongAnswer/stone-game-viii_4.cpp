class Solution {
public:
    int stoneGameVIII(vector<int>& stones) {
        
        int n = stones.size();
        vector<int> dp(n);
        dp[n-1] = stones[n-1];
        for (int i = n-2; i >= 0; --i) {
            dp[i] = dp[i+1] + stones[i];
        }
        int ans = dp[1];
        for (int i = 2; i < n; ++i) {
            ans = max(ans, dp[i] - ans);
        }
        return ans;
    }
};